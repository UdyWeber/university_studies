def eleventh_exercise():
    product_name = input("Digite o nome do produto: ")
    product_price = float(input("Digite o preço do produto: "))

    number_of_products = int(input("Digite o total desse produto: "))

    print(
        f"Simulados {number_of_products} do produto {product_name} vai"
        f"custar {round(number_of_products * product_price, 2)}"
    )


def twelth_exercise():
    """
    comprando entre 3 (inclusive) e 4 (inclusive) produtos, o desconto é de 10%
    comprando entre 5 (inclusive) e 10 (inclusive) produtos, o desconto é de 15%
    comprando mais do que 10 produtos, o desconto é de 20%
    """
    product_name = input("Digite o nome do produto: ")
    product_price = float(input("Digite o preço do produto: "))

    number_of_products = int(input("Digite o total desse produto: "))

    discount = 0

    if number_of_products >= 3 and number_of_products <= 4:
        discount = 0.10
    elif number_of_products <= 10:
        discount = 0.15
    else:
        discount = 0.20

    final_price = number_of_products * product_price

    print(
        f"Simulados {number_of_products} do produto {product_name} iria"
        f"custar {round(final_price, 2)}.\n"
        f"Porem com desconto de {discount * 100}% os "
        f"produtos vão custar {round(final_price - final_price * discount, 2)}"
    )


def thirteenth_exercise():
    """
    A senha de determinado usuário é composta pelo seu nome seguido dos
    números 9876. Crie um programa que solicite ao usuário que digite
    seu nome e sua senha. Caso a senha esteja incorreta, informe uma mensagem de erro.
    Caso a senha esteja correta, informe que o login foi realizado com sucesso.
    """
    name = input("Digite seu nome: ")
    password = input("Digite sua senha: ")

    expected_password = name + "9876"

    if password != expected_password:
        return print("Senha está incorreta")

    print("Login efetuado com successo")


def fourtheenth_exercise():
    """
    Sabendo que o IMC (Índice de Massa Corporal) é dado pelo peso da pessoa
    dividido por sua altura ao quadrado, crie um programa que solicita que o
    usuário informe seu nome e as demais informações necessárias para o cálculo do IMC.
    Seu programa deve imprimir uma mensagem referente à classificação na qual
    a pessoa se encontra, de acordo com o que segue:

    Menor que 18.5: Abaixo do peso
    Entre 18.5 (inclusive) e 24.9 (inclusive): Peso normal
    Entre 25.0 (inclusive) e 29.9 (inclusive): Pré-obesidade
    Entre 30.0 (inclusive) e 34.9 (inclusive): Obesidade Grau 1
    Entre 35.0 (inclusive) e 39.9 (inclusive): Obesidade Grau 2
    40 ou mais: Obesidade Grau 3
    """

    weight = float(input("Digite seu peso: "))
    height = float(input("Digite sua altura: "))

    imc = weight / height**2
    print(f"Seu IMC é de {round(imc, 2)}")

    if imc < 18.5:
        print("Você está abaixo do peso")
    elif imc <= 24.9:
        print("Você está no peso normal")
    elif imc <= 29.9:
        print("Você está em pré-obesidade")
    elif imc <= 34.9:
        print("Você está em obesidade de grau 1")
    elif imc <= 39.9:
        print("Você está em obesidade de grau 2")
    else:
        print("Você está em obesidade de grau 3")


def fifteenth_exercise():
    """
     Solicite ao usuário que informe 3 valores inteiros.
     Depois disso, imprima uma das seguintes mensagens:
     TRIÂNGULO EQUILÁTERO, TRIÂNGULO ESCALENO, TRIÂNGULO ISÓSCELES
     ou NÃO FORMA UM TRIÂNGULO.
     Para a última mensagem, é importante notar que nem todo conjunto
     de 3 valores formam um triângulo, pois os valores devem obedecer à
     Condição de Existência de um Triângulo: um de seus lados deve ser
     maior que o valor absoluto (módulo) da diferença dos outros dois
     lados e menor que a soma dos outros dois lados. Ou seja:

    ( | b - c | < a < b + c) e ( | a - c | < b < a + c) e ( | a - b | < c < a + b)

    Exemplo de valores que formam um triângulo: 16, 20 e 30
    Exemplo de valores que não formam um triângulo: 20, 15 e 5
    """
    a = int(input("Digite o valor inteiro do primeiro lado: "))
    b = int(input("Digite o valor inteiro do segundo lado: "))
    c = int(input("Digite o valor inteiro do terceiro lado: "))

    if not (
        (abs(b - c) < a and a < (b + c))
        and (abs(a - c) < b and b < (a + c))
        and (abs(a - b) < c and c < (a + b))
    ):
        return print("NÃO FORMA UM TRIÂNGULO")

    if a == b and b == c and c == a:
        print("TRIÂNGULO EQUILÁTERO")
    elif a != b and b != c and c != a:
        print("TRIÂNGULO ESCALENO")
    else:
        print("TRIÂNGULO ISÓSCELES")


def sixteenth_exercise():
    """
    Crie um programa que simula um jogo de par ou ímpar entre 2 jogadores.
    Seu programa deve solicitar o nome dos dois jogadores e a opção do
    primeiro jogador (par ou ímpar).
    Em seguida, o programa deve solicitar um valor inteiro para cada jogador,
    referente ao valor que ele vai jogar. No final, imprima quem ganhou o jogo.
    """
    player_one = input("Digite seu nome jogador 1: ").capitalize()
    player_two = input("Digite seu nome jogador 2: ").capitalize()

    odd_or_even = input(f"{player_one} diga o resultado [PAR/IMPAR]: ").upper()

    player_one_number = int(input(f"{player_one} digite um valor inteiro: "))
    player_two_number = int(input(f"{player_two} digite um valor inteiro: "))

    if (player_one_number + player_two_number) % 2 == 0 and odd_or_even == "PAR":
        print(f"{player_one} ganhou!!")
    else:
        print(f"{player_two} ganhou!!")


def seventeenth_exercise():
    """
    Solicite que o usuário informe uma data, solicitando de forma separada o ano,
    O mês e o dia (nesta ordem), todos valores inteiros.
    O ano pode ser qualquer valor entre 0 e 2022.
    O mês deve ser um valor entre 1 (inclusive) e 12 (inclusive).
    O dia deve estar de acordo com o mês informado e, ainda, com o ano (bissexto ou não).
    Acesse https://pt.wikihow.com/Descobrir-se-um-Ano-%C3%A9-Bissexto para ver como calcular
    se um ano é ou não bissexto.
    """
    year = int(input("Digite um ano entre 0 - 2022: "))

    if year < 1 or year > 2022:
        return print(f"O ano {year} não está no limite previsto!")

    is_leap_year = (
        True if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0) else False
    )

    month = int(input("Digite um mês como número inteiro [1 - 12]: "))

    if month < 1 or month > 12:
        return print(f"{month} não é um mês válido!")

    if month in [4, 6, 9, 11]:
        available_days = 30
    elif month == 2 and is_leap_year:
        available_days = 29
    elif month == 2:
        available_days = 28
    else:
        available_days = 31

    day = int(input(f"Digite um dia do mês {month} [1 - {available_days}]: "))

    if day < 1 or day > available_days:
        return print(f"{day} não é um valor valido para o range de dias!")

    print(f"Sua data: {day}-{month}-{year} [BISSEXTO = {is_leap_year}]")


def eighteenth_exercise():
    """
    Crie um programa que solicita, inicialmente, o saldo (em reais)
    de determinada conta corrente.
    Em seguida, apresente duas opções para o usuário escolher:

    1. Realizar um saque

    2. Realizar um depósito

    Em ambos os casos (saque ou depósito), solicite o valor a ser utilizado na
    operação (valor a sacar ou valor a depositar). Sabendo que não é possível
    depositar mais do que R$300,00 de uma vez e que a conta não possui cheque
    especial, mostre na tela o resultado da operação realizada (sucesso ou insucesso)
    e o saldo final da conta após a operação.
    """
    amount = float(input("Digite o saldo da sua conta corrente: "))

    option = int(
        input(
            "1. Realizar um saque\n2. Realizar um depósito\n\nDigite a opção desejada: "
        )
    )

    if option == 1:
        amount_to_withdraw = float(
            input(f"Digite o valor que você deseja sacar [SALDO: R${amount}]: ")
        )

        if amount_to_withdraw > amount:
            return print(
                "Insucesso: O valor desejado para o saque é maior do que o disponivel!"
            )

        print(
            f"Successo: Valor sacado R${amount_to_withdraw} "
            f"restante na conta R${amount - amount_to_withdraw}"
        )
    elif option == 2:
        amount_to_deposit = float(
            input(f"Digite o valor que você deseja depositar [MAX: R$300]: ")
        )

        if amount_to_deposit > 300:
            return print(
                "Insucesso: O valor depositado é maior que o máximo permitido!"
            )

        print(
            f"Successo: Valor R${amount_to_deposit}"
            f"depositado novo saldo R${amount_to_deposit + amount}"
        )
    else:
        return print(f"{option} não é uma operação válida!")


def nineteenth_exercise():
    """
    Sheldon estava em sua casa, sentado no seu lugar no sofá.
    Neste momento, entram em sua sala Penny, Leonard, Rajesh, Howard, Prya e Amy.
    Sheldon, então, teve uma brilhante ideia: jogar “Pedra, papel, tesoura, lagarto, Spock”.
    Sheldon explica, claramente, as regras do jogo:
    “É muito simples. Olhe: tesoura corta papel, papel cobre pedra, pedra esmaga lagarto,
    lagarto envenena Spock, Spock quebra tesoura, tesoura decapita lagarto,
    lagarto come papel, papel desaprova Spock,
    Spock vaporiza pedra e como sempre, pedra destrói tesoura”.

    O que você deve fazer é criar um programa que permita a
    Sheldon e seus amigos jogarem “Pedra, papel, tesoura, lagarto, Spock”.
    Inicialmente, solicite o nome dos 2 jogadores.
    Em seguida, peça para o primeiro jogador digitar sua jogada (do tipo String).
    Depois, peça para o segundo jogador digitar sua jogada (também do tipo String).
    Ao final, imprima o nome do jogador vencedor,
    ou uma mensagem de erro caso algum dos dois não tenha
    digitado uma das String possíveis (“pedra”, “papel”, “tesoura”, “lagarto” ou “spock”).
    """
    player_one = input("Digite seu nome jogador 1: ")
    player_two = input("Digite seu nome jogador 2: ")

    possible_options = ["pedra", "papel", "tesoura", "lagarto", "spock"]

    player_one_option = input(f"Digite sua jogada {player_one.capitalize()}: ").lower()

    if player_one_option not in possible_options:
        return print(f"A opção digitada {player_one_option}, não é uma opção valida")

    player_two_option = input(f"Digite sua jogada {player_two.capitalize()}: ").lower()

    if player_two_option not in possible_options:
        return print(f"A opção digitada {player_two_option}, não é uma opção valida")

    print("Pedra, papel, tesoura, lagarto, spock!")

    winner = player_two

    if player_one_option == player_two_option:
        print("O jogo empatou!")
    elif player_one_option == "pedra" and (
        player_two_option == "tesoura" or player_two_option == "lagarto"
    ):
        winner = player_one
    elif player_one_option == "papel" and (
        player_two_option == "pedra" or player_two_option == "spock"
    ):
        winner = player_one
    elif player_one_option == "tesoura" and (
        player_two_option == "papel" or player_two_option == "lagarto"
    ):
        winner = player_one
    elif player_one_option == "lagarto" and (
        player_two_option == "spock" and player_two_option == "papel"
    ):
        winner = player_one
    elif player_one_option == "spock" and (
        player_two_option == "tesoura" or player_two_option == "pedra"
    ):
        winner = player_one

    print(f"{winner} venceu o jogo!")


def twentyth_exercise():
    """
    Crie um programa que analisa se uma pessoa pode ou não tirar a carteira de motorista.
    Se a pessoa tem 18 anos ou mais, o programa faz 3
    perguntas (ela deve responder via teclado e uma de cada vez). As perguntas são:

    1  – Ao prestar socorro à vítima de um acidente, NÃO se deve:

    a) acionar imediatamente o Corpo de Bombeiros
    b) dar água, comida ou qualquer substância para a vítima cheirar
    c) conversar com a vítima para saber de suas condições gerais
    d) deixar a vítima confortável até a chegada do socorro especializado

    2 – Ao se deparar com uma sinaleira na cor vermelha, você deve:

    a) rir dela
    b) passar mais rápido, pois é perigoso parar
    c) dobrar a direita, pois vermelho indica direita
    d) parar

    3 – Segundo a direção defensiva, quando você está em uma via e um pedestre vai atravessar você:

    a) buzina muito forte para que o pedestre se assuste
    b) atropela o pedestre, pois lugar de pedestre é na calçada
    c) para e dá uma carona para o pedestre, pois é uma lei de trânsito
    d) para e aguarda ele atravessar

    Caso ela acerte 2 ou 3 perguntas, ela está apta para tirar a carteira (respostas corretas, em ordem: b, d, d).
    No final, seu programa deve informar se a pessoa está ou não apta para tirar a carteira de motorista.
    """
    driver_age = int(input("Digite sua idade: "))

    if driver_age < 18:
        return print(
            "Você não tem idade suficiente para fazer a carteira de motorista!"
        )

    total_points = 0

    first_answer = input(
        "1  – Ao prestar socorro à vítima de um acidente, NÃO se deve:\n"
        "a) acionar imediatamente o Corpo de Bombeiros\n"
        "b) dar água, comida ou qualquer substância para a vítima cheirar\n"
        "c) conversar com a vítima para saber de suas condições gerais\n"
        "d) deixar a vítima confortável até a chegada do socorro especializado\n\n"
        "Digite sua resposta: "
    ).lower()

    if first_answer == "b":
        total_points += 1

    second_answer = input(
        "2 – Ao se deparar com uma sinaleira na cor vermelha, você deve:\n"
        "a) rir dela\n"
        "b) passar mais rápido, pois é perigoso parar\n"
        "c) dobrar a direita, pois vermelho indica direita\n"
        "d) parar\n\n"
        "Digite sua resposta: "
    ).lower()

    if second_answer == "d":
        total_points += 1

    third_answer = input(
        "3 – Segundo a direção defensiva, quando você está em uma via e um pedestre vai atravessar você:\n"
        "a) buzina muito forte para que o pedestre se assuste\n"
        "b) atropela o pedestre, pois lugar de pedestre é na calçada\n"
        "c) para e dá uma carona para o pedestre, pois é uma lei de trânsito\n\n"
        "d) para e aguarda ele atravessar\n\n"
        "Digite sua resposta: "
    ).lower()

    if third_answer == "d":
        total_points += 1

    if total_points >= 2:
        print(f"Você marcou {total_points} pontos, já pode tirar sua carteira!")
    else:
        print(f"Você marcou {total_points} pontos, rodou no teste!")
