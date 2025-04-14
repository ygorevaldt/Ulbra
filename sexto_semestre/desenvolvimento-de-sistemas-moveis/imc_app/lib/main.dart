import 'package:flutter/material.dart';

void main() {
  runApp(const IMCApp());
}

class IMCApp extends StatelessWidget {
  const IMCApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Calculadora de IMC',
      themeMode: ThemeMode.system,
      theme: ThemeData(
        scaffoldBackgroundColor: Colors.white,
        primarySwatch: Colors.blue,
        fontFamily: 'Roboto',
        brightness: Brightness.light,
      ),
      darkTheme: ThemeData.dark().copyWith(
        primaryColor: Colors.blue,
        scaffoldBackgroundColor: Colors.grey[900],
      ),
      home: const HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

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

enum Gender { male, female }

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
              (_, __, ___) => ResultadoPage(imc: imc, gender: _selectedGender),
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

class ResultadoPage extends StatelessWidget {
  final double imc;
  final Gender gender;

  const ResultadoPage({super.key, required this.imc, required this.gender});

  String getClassificacao(double imc) {
    if (imc < 18.5) return "Abaixo do peso";
    if (imc < 25) return "Normal";
    if (imc < 30) return "Acima do peso";
    return "Obesidade";
  }

  Color getCorClassificacao(double imc) {
    if (imc < 18.5) return Colors.orange;
    if (imc < 25) return Colors.green;
    if (imc < 30) return Colors.amber;
    return Colors.red;
  }

  String getGeneroTexto() {
    return gender == Gender.male ? "Masculino" : "Feminino";
  }

  @override
  Widget build(BuildContext context) {
    final classificacao = getClassificacao(imc);
    final cor = getCorClassificacao(imc);

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
                "Gênero: ${getGeneroTexto()}",
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
