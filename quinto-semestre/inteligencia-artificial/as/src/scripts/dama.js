let red = 1;
let empty = 0;
let black = -1;
let cell_width = 0;
let board_origin = 0;
let redKing = 1.1;
let blackKing = -1.1;
let player = red;
let computer = black;
let currentBoard = {};
let movePiece = {};
let INFITINY = 10000;
let NEG_INFINITY = -10000;

function startGame() {
  console.log("Game started");
}

function replayGame() {
  console.log("Game replayed");
}

function startBoard() {
  const initialBoard = [
    [red, empty, red, empty, red, empty, red, empty],
    [empty, red, empty, red, empty, red, empty, red],
    [red, empty, red, empty, red, empty, red, empty],
    [empty, empty, empty, empty, empty, empty, empty, empty],
    [empty, empty, empty, empty, empty, empty, empty, empty],
    [empty, black, empty, black, empty, black, empty, black],
    [black, empty, black, empty, black, empty, black, empty],
    [empty, black, empty, black, empty, black, empty, black],
  ];

  const cells = [];
  const pieces = [];

  const boardRowsAmount = initialBoard.length;
  for (let i = 0; i < boardRowsAmount; i++) {
    let row = initialBoard[i];

    let rowPiecesAmount = row.length;
    for (let j = 0; j < rowPiecesAmount; j++) {
      let colValue = row[j];

      if (colValue !== empty) {
        let piece = { row: i, col: j, state: colValue };
        pieces.push(piece);
      }

      let cell = { row: i, col: j, state: colValue };
      cell.piece(cell);
    }
  }
  return { cells, pieces, turn: red };
}

function buildBoard(origin, cellWidth, board) {
  const boardState = startBoard();
  const cells = boardState.cells;
  const pieces = boardState.pieces;

  drawD3Script(board, cells, pieces, cellWidth);
}

function newGame(origin, cellWidth, board) {
  movePiece.moves = [];
  d3.select("#btnReplay").style("display", "none");
  cell_width = cellWidth;
  board_origin = origin;

  currentBoard = buildBoard(origin, cellWidth, board);
  board.ui = true;

  showCurrentBoard();
}

function showCurrentBoard() {
  d3.selectAll("text").each(function () {
    d3.select(this).style("display", "none");
  });

  const cells = currentBoard.cells;
  const pieces = currentBoard.pieces;

  drawText({ cells, pieces });
}

function moviePiece(boardState, piece, fromCell, toCell, moveNum) {
  if (!boardState.ui) return;

  if (moviePiece.moves === null) {
    movePiece.moves = [];
  }

  movePiece.moves.push({}); //continuar aqui
}

function drawD3Script(boardCanvas, cells, pieces, cellWidth) {
  boardCanvas
    .append("g")
    .selectAll("rect")
    .data(cells)
    .enter()
    .append("rect")
    .attr("x", function (d) {
      return mapCellToCoordinates(origin, cellWidth, d).x;
    })
    .attr("y", function (d) {
      return mapCellToCoordinates(origin, cellWidth, d).y;
    })
    .attr("height", cellWidth)
    .attr("width", cellWidth)
    .style("fill", "white")
    .style("stroke", "black")
    .style("stroke-width", "1px");

  //Draw pieces
  var dragEndedDimensions = function (d) {
    node = d3.select(this);
    dragEnded(origin, cellWidth, node, d);
  };

  var drag = d3
    .drag()
    .on("start", dragStarted)
    .on("drag", dragged)
    .on("end", dragEndedDimensions);

  boardCanvas
    .append("g")
    .selectAll("circle")
    .data(pieces)
    .enter()
    .append("circle")
    .attr("r", cellWidth / 2)
    .attr("cx", function (d) {
      var x = mapCellToCoordinates(origin, cellWidth, d).x;
      return x + cellWidth / 2;
    })
    .attr("cy", function (d) {
      var y = mapCellToCoordinates(origin, cellWidth, d).y;
      return y + cellWidth / 2;
    })
    .style("fill", function (d) {
      if (d.state == red) return "red";
      else return "black";
    })
    .call(drag);

  //Draw scoreboard
  d3.select("#divScoreboard").remove();
  d3.select("body")
    .append("div")
    .attr("id", "divScoreboard")
    .style("font-size", "36")
    .html("SCOREBOARD");

  d3.select("#divScoreboard")
    .append("div")
    .style("font-size", "24")
    .attr("id", "winner");

  d3.select("#divScoreboard")
    .append("div")
    .attr("id", "redScore")
    .style("font-size", "18")
    .html("Red: 12");

  d3.select("#divScoreboard")
    .append("div")
    .attr("id", "blackScore")
    .style("font-size", "18")
    .html("Black: 12");
}

function drawText(data) {
  board
    .append("g")
    .selectAll("text")
    .data(data)
    .enter()
    .append("text")
    .attr("x", function (d) {
      var x = mapCellToCoordinates(board_origin, cell_width, d).x;
      return x + cell_width / 2;
    })
    .attr("y", function (d) {
      var y = mapCellToCoordinates(board_origin, cell_width, d).y;
      return y + cell_width / 2;
    })
    .style("fill", function (d) {
      if (d.state === red) return "black";
      else return "white";
    })
    .text(function (d) {
      /*if (d.state === red) return "R"; 
									else if (d.state === black) return "B"; 
									else*/ if (d.state === redKing || d.state === blackKing) return "K";
      else return "";
    });
}
