def baskara():
    print("\n--------- Calculadora de Baskara ---------")
    a = 0

    while a == 0:
        a = int(input("Digite o valor de A: "))

        if a == 0:
            print("Não se trata de uma equação do segundo grau!")

    b = int(input("Digite o valor de B: "))
    c = int(input("Digite o valor de C: "))

    delta = (b**2) - 4 * (a * c)

    if delta < 0:
        print(
            "O resultado do delta foi um número negativo não podemos prosseguir"
            " pois a equação não possui raizes reais"
        )
    elif delta == 0:
        print(f"A equação possui apenas uma raiz real que é: {-b / (2 * a):.2f} ")
    else:
        rad_delta = delta ** (1 / 2)

        x_positive = (-b + rad_delta) / (2 * a)
        x_negative = (-b - rad_delta) / (2 * a)

        print(f"\nX positivo: {x_positive:.2f}\nX negativo: {x_negative:.2f}")


def analise_cpf():
    print("\n--------- Analizar CPF ---------")

    tries = 3

    while tries > 0:
        cpf = input("Digite um CPF com apenas caracteres numéricos para validarmos: ")

        if not cpf.isdigit() or len(cpf) != 11:
            if tries == 1:
                return print("Todos os CPFs digitados eram invalidos. Encerrando!")
            else:
                tries -= 1
                remaining_tries = (
                    f"Restam {tries} tentativas." if tries > 1 else "Resta 1 tentativa."
                )
                print(f"CPF: {cpf} é invalido!\n{remaining_tries}\n")
        else:
            return print(f"CPF: {cpf} é valido!")


def checkout_text_len():
    print("\n--------- Checar Tamanho de Texto ---------")
    user_text_len = len(input("Digite um texto qualquer para avaliarmos o tamanho: "))

    if user_text_len < 5:
        print("Seu texto é muito pequeno!")
    elif user_text_len < 15:
        print("Seu texto é médio!")
    elif user_text_len < 20:
        print("Seu texto é grande!")
    else:
        print("Seu texto é invalido!")


def char_counter():
    print("\n--------- Contador de Caracteres ---------")
    user_text = input("Digite um texto qualquer: ").lower()

    total_chars = len(user_text)

    space_count = user_text.count(" ")

    vowels_count = user_text.count("a")
    vowels_count += user_text.count("e")
    vowels_count += user_text.count("i")
    vowels_count += user_text.count("o")
    vowels_count += user_text.count("u")

    other_chars_count = total_chars - space_count - vowels_count

    print(
        f"Número total de caracteres: {total_chars}\n"
        f"Número de espaços: {space_count}\n"
        f"Número de vogais: {vowels_count}\n"
        f"Número de outros caracteres: {other_chars_count}"
    )


def date_checker():
    print("\n--------- Conferir Data ---------")
    year = int(input("Digite um ano entre 0 - 2022: "))

    if year < 0 or year > 2022:
        return print(f"O ano {year} não está no limite previsto!")

    is_leap_year = (
        True if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0) else False
    )

    while True:
        month = int(input("Digite um mês como número inteiro [1 - 12]: "))
        if month < 1 or month > 12:
            print(f"{month} não é um mês válido!")
        else:
            break

    if month in [4, 6, 9, 11]:
        available_days = 30
    elif month == 2 and is_leap_year:
        available_days = 29
    elif month == 2:
        available_days = 28
    else:
        available_days = 31

    while True:
        day = int(input(f"Digite um dia do mês {month} [1 - {available_days}]: "))

        if day < 1 or day > available_days:
            print(f"{day} não é um valor valido para o range de dias!")
        else:
            break

    print(
        f"Sua data: {day}-{month}-{year} [BISSEXTO = {'SIM' if is_leap_year else 'NÃO'}]"
    )


def triangle_identifier():
    print("\n--------- Verificar Triângulo ---------")
    a = int(input("Digite o valor inteiro do primeiro lado: "))
    b = int(input("Digite o valor inteiro do segundo lado: "))
    c = int(input("Digite o valor inteiro do terceiro lado: "))

    if not (
        (abs(b - c) < a < (b + c))
        and (abs(a - c) < b < (a + c))
        and (abs(a - b) < c < (a + b))
    ):
        return print("NÃO FORMA UM TRIÂNGULO")

    if a == b and b == c and c == a:
        print("TRIÂNGULO EQUILÁTERO")
    elif a != b and b != c and c != a:
        print("TRIÂNGULO ESCALENO")
    else:
        print("TRIÂNGULO ISÓSCELES")


def grade_a_exercise():
    option = 0
    tries = 5

    while option != 7:
        option = int(
            input(
                "\n--------- Menu de Opções ---------\n"
                "1) Verificar triângulo\n\n"
                "2) Calcular equação do segundo grau\n\n"
                "3) Conferir data\n\n"
                "4) Verificar tamanho do texto\n\n"
                "5) Analisar CPF\n\n"
                "6) Contar caracteres\n\n"
                "7) Sair\n\n"
                "Digite a opção desejada: "
            )
        )

        if option > 7 or option < 1:
            if tries == 1:
                return print(
                    "Parece que você não está entendendo o"
                    "funcionamento do sistema. Até mais."
                )
            else:
                tries -= 1
                print(
                    "Opção invalida tente novamente!"
                    f"você tem mais {tries} tentativas."
                )
                continue

        if option == 7:
            print("Obrigado por utilizar nosso sistema.")
            break

        operation_handler = {
            1: lambda: triangle_identifier(),
            2: lambda: baskara(),
            3: lambda: date_checker(),
            4: lambda: checkout_text_len(),
            5: lambda: analise_cpf(),
            6: lambda: char_counter(),
        }

        operation_handler[option]()


grade_a_exercise()
