const model = {
  turn: "white",
  whiteLeft: 0,
  blackLeft: 0,

  board: {
    rows: 0,
    columns: 0,
    selected: null,
    positions: [],

    addWhitePieces(piecesPerSide) {
      model.whiteLeft = piecesPerSide;
      let remaining = piecesPerSide;
      let currentRow = 0;
      let currentColumn = 1;
      while (remaining > 0) {
        this.positions[currentRow][currentColumn] = new WhitePiece(
          currentRow,
          currentColumn
        );
        currentColumn =
          currentColumn === this.columns - 1
            ? currentColumn + 1
            : currentColumn === this.columns - 2
            ? currentColumn + 3
            : currentColumn + 2;
        if (currentColumn >= this.columns) currentRow++;
        currentColumn %= this.columns;
        remaining--;
      }
    },

    addBlackPieces(piecesPerSide) {
      model.blackLeft = piecesPerSide;
      let remaining = piecesPerSide;
      let currentRow = this.rows - 1;
      let currentColumn = this.columns - 2;
      while (remaining > 0) {
        this.positions[currentRow][currentColumn] = new BlackPiece(
          currentRow,
          currentColumn
        );
        currentColumn -= 2;
        if (currentColumn < 0) currentRow--;
        currentColumn =
          currentColumn === -1
            ? this.columns - 2
            : currentColumn === -2
            ? this.columns - 1
            : currentColumn % this.columns;
        remaining--;
      }
    },

    initBoard(rows, columns, piecesPerSide) {
      this.rows = rows;
      this.columns = columns;
      this.positions = Array.from({ length: rows }, () =>
        Array.from({ length: columns }, (_, j) => new Piece(_, j))
      );
      this.addWhitePieces(piecesPerSide);
      this.addBlackPieces(piecesPerSide);
    },

    drawBoard() {
      const boardElement = document.querySelector("main");
      boardElement.innerHTML = ""; // Limpa o tabuleiro de forma mais eficiente

      const boardDiv = document.createElement("div");
      boardDiv.className = "board";
      boardElement.appendChild(boardDiv);

      for (let i = 0; i < this.rows; i++) {
        for (let j = 0; j < this.columns; j++) {
          const isWhite = (i + j) % 2 === 0;
          const cell = document.createElement("div");
          cell.setAttribute("row", i);
          cell.setAttribute("column", j);
          cell.className = isWhite ? "cell cell-white" : "cell cell-black";

          const piece = this.positions[i][j];
          if (!piece.isEmpty()) {
            const newPiece = document.createElement("img");
            newPiece.setAttribute("src", piece.src);
            cell.appendChild(newPiece);
            if (piece.selected) cell.classList.add("selected");
          }

          if (piece.highlighted) {
            cell.classList.add("highlight");
            cell.addEventListener("click", () => {
              this.selected.changePosition(i, j);
              this.unselectCell();
              this.drawBoard();
            });
          } else {
            cell.addEventListener("click", () => {
              this.selectCell(i, j);
              this.drawBoard();
            });
          }
          boardDiv.appendChild(cell);
        }
      }
    },

    selectCell(row, column) {
      const cell = this.positions[row][column];
      if (this.selected) {
        this.selected.selected = false;
        this.clearHighlights();
      }
      this.selected = null;

      if (!cell.isEmpty() && model.turn === cell.color) {
        this.selected = cell;
        this.selected.selected = true;
        this.selected.highlightMoves(this.selected.row, this.selected.column);
      }
    },

    unselectCell() {
      if (this.selected) {
        this.selected.selected = false;
        this.clearHighlights();
      }
      this.selected = null;
    },

    clearHighlights() {
      for (let i = 0; i < this.rows; i++) {
        for (let j = 0; j < this.columns; j++) {
          this.positions[i][j].highlighted = false;
        }
      }
    },

    isOutOfBounds(row, column) {
      return (
        row >= this.rows || row < 0 || column >= this.columns || column < 0
      );
    },
  },
};

class Piece {
  constructor(row, column) {
    this.row = parseInt(row);
    this.column = parseInt(column);
    this.src = "";
    this.selected = false;
    this.highlighted = false;
  }

  changePosition(newRow, newColumn) {
    model.board.positions[this.row][this.column] = new Piece(
      this.row,
      this.column
    );
    if (Math.abs(this.row - newRow) > 1) {
      const eatenRowPos = (this.row + newRow) / 2;
      const eatenColumnPos = (this.column + newColumn) / 2;
      model.board.positions[eatenRowPos][eatenColumnPos] = new Piece(
        eatenRowPos,
        eatenColumnPos
      );
      this.color === "white" ? model.blackLeft-- : model.whiteLeft--;
    }

    this.row = newRow;
    this.column = newColumn;
    model.board.positions[this.row][this.column] = this;

    model.turn = model.turn === "white" ? "black" : "white";

    if (this.turnDama()) {
      model.board.positions[this.row][this.column] =
        model.turn === "black"
          ? new WhiteDama(this.row, this.column)
          : new BlackDama(this.row, this.column);
    }
  }

  highlightMove(row, column) {
    if (!model.board.isOutOfBounds(row, column)) {
      const cellTo = model.board.positions[row][column];
      if (cellTo.isEmpty()) {
        cellTo.highlighted = true;
        return false;
      }
      return this.color !== cellTo.color;
    }
    return false;
  }

  isEmpty() {
    return true;
  }
}

class BlackPiece extends Piece {
  constructor(row, column) {
    super(row, column);
    this.src = "img/black.png";
    this.color = "black";
  }

  highlightMoves(row, column) {
    if (this.highlightMove(row - 1, column - 1)) {
      this.highlightMove(row - 2, column - 2);
    }
    if (this.highlightMove(row - 1, column + 1)) {
      this.highlightMove(row - 2, column + 2);
    }
  }

  turnDama() {
    return this.row === 0;
  }

  isEmpty() {
    return false;
  }
}

class WhitePiece extends Piece {
  constructor(row, column) {
    super(row, column);
    this.src = "img/white.png";
    this.color = "white";
  }

  highlightMoves(row, column) {
    if (this.highlightMove(row + 1, column + 1)) {
      this.highlightMove(row + 2, column + 2);
    }
    if (this.highlightMove(row + 1, column - 1)) {
      this.highlightMove(row + 2, column - 2);
    }
  }

  turnDama() {
    return this.row === model.board.rows - 1;
  }

  isEmpty() {
    return false;
  }
}

class BlackDama extends BlackPiece {
  constructor(row, column) {
    super(row, column);
    this.src = "img/blackdama.png";
  }

  highlightMoves(row, column) {
    this.highlightMove(row + 1, column + 1);
    this.highlightMove(row - 1, column - 1);
    this.highlightMove(row - 1, column + 1);
    this.highlightMove(row + 1, column - 1);
  }
}

class WhiteDama extends WhitePiece {
  constructor(row, column) {
    super(row, column);
    this.src = "img/whitedama.png";
  }

  highlightMoves(row, column) {
    this.highlightMove(row + 1, column + 1);
    this.highlightMove(row - 1, column - 1);
    this.highlightMove(row - 1, column + 1);
    this.highlightMove(row + 1, column - 1);
  }
}

const init = function () {
  model.board.initBoard(8, 8, 12);
  model.board.drawBoard();
};

const modelProxy = new Proxy(model, {
  set(target, property, value) {
    target[property] = value;
    if (property === "turn") {
      document.querySelector("#info h1 span").innerHTML =
        value === "white" ? "Branco" : "Preto";
    } else if (property === "whiteLeft" || property === "blackLeft") {
      document.querySelector("#white-counter span").innerHTML = model.whiteLeft;
      document.querySelector("#black-counter span").innerHTML = model.blackLeft;

      if (model.whiteLeft === 0) {
        alert("Jogador Preto Ganhou!");
        init();
      } else if (model.blackLeft === 0) {
        alert("Jogador Branco Ganhou!");
        init();
      }
    }
    return true;
  },
});

init();
