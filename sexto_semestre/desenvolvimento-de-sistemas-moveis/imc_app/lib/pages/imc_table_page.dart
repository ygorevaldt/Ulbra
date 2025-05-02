import 'package:flutter/material.dart';

class TabelaIMCPage extends StatelessWidget {
  const TabelaIMCPage({super.key});

  @override
  Widget build(BuildContext context) {
    final rows = [
      _buildRow("Menor que 18.5", "Abaixo do peso", Colors.orange),
      _buildRow("18.5 a 24.9", "Normal", Colors.green),
      _buildRow("25 a 29.9", "Acima do peso", Colors.amber),
      _buildRow("30 ou mais", "Obesidade", Colors.red),
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text("Tabela de IMC"),
        backgroundColor: Colors.lightBlueAccent,
      ),
      body: ListView.separated(
        padding: const EdgeInsets.all(24),
        itemCount: rows.length,
        separatorBuilder: (_, __) => const SizedBox(height: 16),
        itemBuilder: (_, index) => rows[index],
      ),
    );
  }

  Widget _buildRow(String faixa, String classificacao, Color cor) {
    return Container(
      decoration: BoxDecoration(
        // ignore: deprecated_member_use
        color: cor.withOpacity(0.1),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: cor),
      ),
      padding: const EdgeInsets.symmetric(vertical: 16, horizontal: 16),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(faixa, style: const TextStyle(fontSize: 16)),
          Text(
            classificacao,
            style: TextStyle(fontWeight: FontWeight.bold, color: cor),
          ),
        ],
      ),
    );
  }
}
