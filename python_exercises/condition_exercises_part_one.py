def first_exercise():
    number = int(input("Digite um número: "))
    print(f"{number} é par") if number % 2 == 0 else print(f"{number} é impar")


def second_exercise():
    first_number = int(input("Digite o primeiro número: "))
    second_number = int(input("Digite o segundo número: "))

    print(first_number) if first_number > second_number else print(second_number)


def third_exercise():
    a = int(input("Digite o primeiro número: "))
    b = int(input("Digite o segundo número: "))

    if b == 0:
        return print("Erro: tentativa de divisão por 0")

    print(f"A dividido por B é: {a / b}")


def fourth_exercise():
    first_number = int(input("Digite o primeiro número: "))
    second_number = int(input("Digite o segundo número: "))
    third_number = int(input("Digite o terceiro número: "))

    if first_number < second_number and first_number < third_number:
        lesser_number = first_number
    elif second_number < third_number:
        lesser_number = second_number
    else:
        lesser_number = third_number

    print(f"{lesser_number} foi o menor número digitado!")


def fifth_exercise():
    product_price = float(input("Digite o valor do produto: "))

    if product_price <= 0:
        print("Preço inválido")
    elif 0 < product_price <= 30:
        print("Preço baixo")
    elif 30 < product_price <= 50:
        print("Preço médio")
    else:
        print("Preço alto")


def sixth_exercise():
    product_price = float(input("Digite o valor do produto: "))

    fee = 0.0

    if product_price < 0:
        return print("Erro: Valor do produto não pode ser negativo!")
    elif product_price < 100:
        fee = 0.1
        product_price += product_price * fee
    elif 100 <= product_price < 300:
        fee = 0.2
        product_price += product_price * fee
    elif 300 <= product_price < 1000:
        fee = 0.5
        product_price += product_price * fee

    print(f"Valor do produto com taxa de {fee * 100}% aplicada é: {product_price}")


def seventh_exercise():
    # Anos bissextos são aqueles que são múltiplos de 4,
    # como 1996, 2000, 2004 etc (que podem ser divididos por 4 deixando resto 0).
    # Porém, há uma exceção: múltiplos de 100 que não sejam múltiplos de 400.

    year = int(input("Digite um ano: "))

    if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
        print(f"O ano {year} é um ano bissexto")
    else:
        print(f"O ano {year} não é um ano bissexto")


def eighth_exercise():
    while True:
        option = int(
            input(
                "Digite 1 para somar dois valores\n"
                "Digite 2 para subtrair dois valores\n"
                "Digite 3 para multiplicar dois valores\n"
                "Digite 4 para dividir dois valores\n"
                "Digite 5 para realizar uma potência entre dois valores\n"
                "Digite 6 para realizar uma radiciação entre dois valores\n"
                "Digite qualquer outro número para sair\n\n"
                "Digite sua opção aqui: "
            )
        )

        if option > 6:
            return print("Finalizando calculadora, até a próxima!")

        first_number = float(input("\nDigite o primeiro número: "))
        second_number = float(input("Digite o segundo número: "))

        if option == 4 and second_number == 0:
            print("Erro: Tentativa de divisão por 0\n")
            continue

        operation_handler = {
            1: first_number + second_number,
            2: first_number - second_number,
            3: first_number * second_number,
            4: first_number / second_number,
            5: first_number**second_number,
            6: first_number ** (1 / second_number),
        }

        result = operation_handler[option]
        print(f"O valor da operação foi: {result}\n")


def ninth_exercise():
    a_grade = float(input("Digite a nota do grau A: "))

    if a_grade < 0:
        return print("Valor digitado não pode ser negativo!")

    b_grade = float(input("Digite b nota do grau B: "))

    if b_grade < 0:
        return print("Valor digitado não pode ser negativo!")

    final_grade = a_grade * 0.33 + b_grade * 0.67
    print(final_grade)

    if final_grade >= 6.0:
        print("Não há necessidade de realizar o grau C")
    else:
        print("Será necessario realizar o grau C")


def tenth_exercise():
    vowels = ["a", "e", "i", "o", "u"]

    letter_from_input = input("Digite um letra: ")

    if letter_from_input in vowels:
        print("A letra digitada é uma vogal")
    else:
        print("A letra digitada é uma consoante")
