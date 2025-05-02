import 'package:flutter/material.dart';
import '../models/gender.dart';

String getClassifcation(double imc) {
  if (imc < 18.5) return "Abaixo do peso";
  if (imc < 25) return "Normal";
  if (imc < 30) return "Acima do peso";
  return "Obesidade";
}

Color getClassificationColor(double imc) {
  if (imc < 18.5) return Colors.orange;
  if (imc < 25) return Colors.green;
  if (imc < 30) return Colors.amber;
  return Colors.red;
}

String getGenderText(Gender gender) {
  return gender == Gender.male ? "Masculino" : "Feminino";
}
