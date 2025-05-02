import 'package:flutter/material.dart';
import '../models/gender.dart';
import '../pages/imc_table_page.dart';
import '../pages/result_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final _pesoController = TextEditingController();
  final _alturaController = TextEditingController();

  Gender _selectedGender = Gender.male;

  void _calcularIMC() {
    final peso = double.tryParse(_pesoController.text.replaceAll(',', '.'));
    final altura =
        double.tryParse(_alturaController.text.replaceAll(',', '.')) ?? 0;

    if (peso != null && altura > 0) {
      final alturaM = altura / 100;
      final imc = peso / (alturaM * alturaM);

      Navigator.push(
        context,
        PageRouteBuilder(
          pageBuilder:
              (_, __, ___) => ResultPage(imc: imc, gender: _selectedGender),
          transitionsBuilder: (_, animation, __, child) {
            return FadeTransition(opacity: animation, child: child);
          },
        ),
      ).then((_) {
        _pesoController.clear();
        _alturaController.clear();
        setState(() {});
      });
    } else {
      showDialog(
        context: context,
        builder:
            (_) => AlertDialog(
              title: const Text("Dados inválidos"),
              content: const Text(
                "Por favor, preencha os campos corretamente.",
              ),
              actions: [
                TextButton(
                  onPressed: () => Navigator.pop(context),
                  child: const Text("OK"),
                ),
              ],
            ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
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
              const SizedBox(height: 24),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  _genderOption(Gender.male, "Masculino"),
                  const SizedBox(width: 16),
                  _genderOption(Gender.female, "Feminino"),
                ],
              ),
              const SizedBox(height: 32),
              _inputField("Peso (kg)", _pesoController),
              const SizedBox(height: 20),
              _inputField("Altura (cm)", _alturaController),
              const SizedBox(height: 30),
              ElevatedButton(
                onPressed: _calcularIMC,
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.lightBlueAccent,
                  padding: const EdgeInsets.symmetric(vertical: 16),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                  minimumSize: const Size.fromHeight(50),
                ),
                child: const Text(
                  "Calcular seu IMC",
                  style: TextStyle(fontSize: 18, color: Colors.white),
                ),
              ),
              TextButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (_) => const TabelaIMCPage()),
                  );
                },
                child: const Text(
                  "Ver tabela de IMC",
                  style: TextStyle(fontSize: 16, color: Colors.blueAccent),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _inputField(String label, TextEditingController controller) {
    return TextField(
      controller: controller,
      keyboardType: TextInputType.number,
      decoration: InputDecoration(
        labelText: label,
        border: const OutlineInputBorder(),
      ),
    );
  }

  Widget _genderOption(Gender gender, String label) {
    final isSelected = _selectedGender == gender;
    return GestureDetector(
      onTap: () {
        setState(() {
          _selectedGender = gender;
        });
      },
      child: Column(
        children: [
          CircleAvatar(
            radius: 30,
            backgroundColor: isSelected ? Colors.blueAccent : Colors.grey[300],
            child: Icon(
              gender == Gender.male ? Icons.male : Icons.female,
              size: 32,
              color: Colors.white,
            ),
          ),
          const SizedBox(height: 8),
          Text(label),
        ],
      ),
    );
  }
}
