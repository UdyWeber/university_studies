def exercise_one():
    x = 0

    while x < 13:
        input(f"Digite o nome {x + 1}° nome: ")
        x += 1


def exercise_two():
    x = 0

    while x < 1001:
        print(x)
        x += 1


def exercise_three():
    x = 0

    while x < 2001:
        if x % 2 == 0:
            print(x)

        x += 1


def exercise_five():
    x = 1000
    while x > -1:
        print(x)
        x -= 1


def exercise_six():
    x = 1
    y = str(float(input("Digite um número de ponto flutuante: ")))

    while x < 5:
        inputed_value = float(input("Digite um número de ponto flutuante: "))

        y += f", {inputed_value}"
        x += 1

    print(y)


def exercise_seven():
    x = 0
    total = 0

    while x < 10:
        y = int(input("Digite um número inteiro: "))
        total += y

        x += 1

    print(f"Somatória dos números digitados: {total}")


def exercise_eight():
    quant = int(input("Digite o total de números que você deseja digitar: "))

    while quant > 0:
        number = int(input("Digite um número inteiro: "))

        if number == 0:
            print("O número é zero!")
        elif number < 0:
            print("O número é negativo!")
        else:
            print("O número é positivo!")

        quant += 1


def exercise_nine():
    val_one = int(input("Digite um valor inteiro: "))
    val_two = int(input("Digite um valor inteiro: "))

    if val_one < 0 or val_two < 0:
        return
    elif val_one == 0 and val_two == 0:
        return
    elif val_one > val_two:
        while val_two < val_one - 1:
            val_two += 1
            print(val_two) if val_two % 2 == 0 else None
    else:
        while val_one < val_two - 1:
            val_one += 1
            print(val_one) if val_one % 2 == 0 else None


def exercise_ten():
    x = 0
    total = 0
    while x < 199:
        total += 1
        x += 1
    print(f"Total do range {total}")


def exercise_eleven():
    initial = int(input("Digite o primeiro número do range: "))
    end = int(input("Digite o segundo número do range: "))

    print(f"Calulando os números pares e impares dentro do range {initial} - {end}")

    odd_total = 0
    even_total = 0

    while initial < end - 1:
        initial += 1

        if initial % 2 == 0:
            even_total += initial
        else:
            odd_total += initial

    print(
        f"Soma dos pares dentro do range é {even_total} e a dos impares é {odd_total}"
    )


def exercise_twelve():
    total_loops = 0
    total_from_input = 0

    while True:
        current_number = int(
            input(
                "Digite um número positivo para somar na média ou um negativo para parar o programa: "
            )
        )

        if current_number < 0:
            break

        total_from_input += current_number
        total_loops += 1

    average = total_from_input / total_loops

    print(f"A média entre os números positivos digitados é: {average}")


def exercise_thirteen():
    number = int(input("Digite o número para ser calculado o fatorial: "))

    if number < 0:
        return print("Não é permitido calcular o fatorial de números negativos!")

    factorial_of_number = 1
    x = 1

    while x < number + 1:
        factorial_of_number *= x
        x += 1

    print(factorial_of_number)


def exercise_fourteen():
    number = int(input("Digite o número que você deseja ver se é primo: "))

    if number <= 1:
        print("Número não é primo!")
    elif number == 2 or number == 3:
        print("Número é primo!")
    else:
        x = 3

        while x < number:
            if number % 2 == 0 or number % 0 == 3 or number % x == 0:
                return print("Número não é primo!")
            x += 1

        print("Número é primo!")


def exercise_fifteen():
    x = 3

    sum_of = "2, 3"
    # Sum of two first primes
    total = 5

    while x < 201:
        if x % 2 != 0 and x % 3 != 0:
            sum_of += f", {x}"
            total += x

        x += 1

    print(f"Soma dos primos {sum_of}: {total}")
