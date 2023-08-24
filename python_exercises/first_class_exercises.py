def exercise_one():
    nome = input("Digite seu nome: ")

    print(f"Seu nome é {nome}")


def exercise_two():
    nome = input("Digite seu nome: ")
    idade = int(input("Digite sua idade: "))

    print(f"Seu nome é {nome} e sua idade é {idade}")


def exercise_three():
    nome = input("Digite seu nome: ")

    print(f"Seu nome é {nome}")

    altura = float(input("Digite sua altura: "))

    print(f"Sua altura é {altura}")
    print("Obrigado pelas informações!")


def exercise_four():
    pais = input("Digite o nome do seu país: ")
    unidade_federativa = input("Digite a sua UF (Unidade Federativa): ")
    cep = input("Digite seu CEP: ")
    cidade = input("Digite sua cidade: ")
    bairro = input("Digite o nome do seu bairro: ")
    rua = input("Digite o nome da sua rua: ")
    numero_da_casa = int(input("Digite o número da sua casa: "))

    print(
        f"Este é seu endereço: {rua} {numero_da_casa}, {bairro},"
        f" {cidade}-{unidade_federativa}, {pais} {cep}"
    )


def exercise_five():
    soma = 0
    produto = 1

    for index in range(5):
        numero_digitado = int(input(f"Digite o {index + 1}° número: "))
        soma += numero_digitado
        produto *= numero_digitado

    print(f"A soma dos valores digitados é: {soma}")
    print(f"O produto dos valores digitados é: {produto}")


def exercise_six():
    a = int(input("Digite o 1° número: "))
    b = int(input("Digite o 2° número: "))
    c = int(input("Digite o 3° número: "))
    d = int(input("Digite o 4° número: "))
    e = int(input("Digite o 5° número: "))

    # sabendo que B e C são respectivamente a base e a altura de
    # um triângulo, imprima a área deste triângulo
    area_triangulo = (b * c) / 2
    print(f"A área do trinagulo de base {b} e altura {c} é {area_triangulo}")

    # sabendo que A, B, C e D formam um retângulo, imprima o
    # perímetro deste retângulo
    area_retangulo = a + b + c + d
    print(
        f"O perímetro de um retângulo com os lados sendo"
        f"({a}, {b}, {c}, {d}) é {area_retangulo}"
    )

    # sabendo que E é o valor do raio de um determinado círculo,
    # imprima a área deste círculo
    area_circulo = e**2 * 3.14
    print(f"A área do circulo de raio {e} é: {area_circulo}")


def exercise_seven():
    # Uma determinada disciplina possui apenas 3 avaliações: o
    # trabalho (que vale 10% da nota), a prova (que vale 60% da
    # nota) e o teste (que vale 30% da nota).

    nota_trabalho = float(input("Digite a nota do trabalho: "))
    nota_trabalho *= 0.1

    nota_prova = float(input("Digite a nota da prova: "))
    nota_prova *= 0.6

    nota_teste = float(input("Digite a nota do teste: "))
    nota_teste *= 0.3

    nota_final = round(nota_trabalho + nota_prova + nota_teste, 2)
    print(f"Sua nota final é: {nota_final}")


def exercise_eight():
    # Uma disciplina possui Grau A e Grau B. A nota do Grau A vale
    #    33% da nota final, enquanto a nota do Grau B vale 67% da
    #    nota final. O Grau A possui as seguintes avaliações:
    #    – Atividade prática: 45% da nota do Grau A
    #    – Atividade teórica: 55% da nota do Grau A
    # Já o Grau B possui as seguintes avaliações:
    #    – Prova em laboratório: 60% da nota do Grau B
    #    – Teste teórico: 20% da nota do Grau B
    #    – Trabalho extraclasse: 20% da nota do Grau B

    print("------ Notas do Grau A ------")
    atividade_pratica = float(input("Digite a nota da atividade prática: "))
    atividade_pratica *= 0.45
    atividade_teorica = float(input("Digite a nota da atividade teórica: "))
    atividade_teorica *= 0.55

    final_grade_a = round(atividade_teorica + atividade_pratica, 2)
    print(f"A nota do grau A é {final_grade_a}")

    final_grade_a *= 0.33

    print("------ Notas do Grau B ------")
    prova_laboratorio = float(input("Digite a nota da prova em laboratório: "))
    prova_laboratorio *= 0.60

    teste_teorico = float(input("Digite a nota do teste teórico: "))
    teste_teorico *= 0.20

    trabalho_extraclasse = float(input("Digite a nota do trabalho teórico: "))
    trabalho_extraclasse *= 0.20

    final_grade_b = round(trabalho_extraclasse + teste_teorico + prova_laboratorio, 2)
    print(f"A nota do grau B é {final_grade_b}")

    final_grade_b *= 0.67

    nota_final = round(final_grade_b + final_grade_a, 2)
    print(f"A nota final do curso é {nota_final}")
