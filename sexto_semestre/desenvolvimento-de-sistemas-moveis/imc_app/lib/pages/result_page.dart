import 'package:flutter/material.dart';
import '../models/gender.dart';
import '../utils/imc_utils.dart';

class ResultPage extends StatelessWidget {
  final double imc;
  final Gender gender;

  const ResultPage({super.key, required this.imc, required this.gender});

  @override
  Widget build(BuildContext context) {
    final classificacao = getClassifcation(imc);
    final cor = getClassificationColor(imc);

    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            children: [
              const Align(
                alignment: Alignment.centerLeft,
                child: Text(
                  'Seu corpo',
                  style: TextStyle(fontSize: 16, color: Colors.black54),
                ),
              ),
              const SizedBox(height: 8),
              const Text(
                'Calculadora de IMC',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 40),
              Text(
                "Gênero: ${getGenderText(gender)}",
                style: const TextStyle(fontSize: 16),
              ),
              const SizedBox(height: 20),
              Text(
                "Seu IMC",
                style: TextStyle(fontSize: 18, color: Colors.grey[700]),
              ),
              const SizedBox(height: 8),
              Text(
                imc.toStringAsFixed(1),
                style: TextStyle(
                  fontSize: 48,
                  fontWeight: FontWeight.bold,
                  color: cor,
                ),
              ),
              const SizedBox(height: 8),
              Text(
                classificacao,
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.w500,
                  color: cor,
                ),
              ),
              const SizedBox(height: 30),
              TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text(
                  "Calcular novamente",
                  style: TextStyle(fontSize: 16, color: Colors.blueAccent),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
