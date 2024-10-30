import random
 
def rzuc_koscia(ilosc_rzutow):
    return [random.randint(1, 6) for _ in range(ilosc_rzutow)]
 
def sumuj_punkty(wyniki):
    punkty = 0
    for liczba_oczek in set(wyniki):
        if wyniki.count(liczba_oczek) >= 2:
            punkty += liczba_oczek * wyniki.count(liczba_oczek)
    return punkty
 
while True:
    ilosc_rzutow = int(input("Ile razy chcesz rzucić kością? (3-10): "))
    if 3 <= ilosc_rzutow <= 10:
        break
    else:
        print("Proszę podać liczbę w zakresie od 3 do 10.")
 
wyniki = rzuc_koscia(ilosc_rzutow)
print("Wyniki rzutów:", wyniki)
 
suma_punktow = sumuj_punkty(wyniki)
print("Suma zdobytych punktów (tylko za oczka, które wystąpiły co najmniej 2 razy):", suma_punktow)
 
while True:
    wybor = input("Czy chcesz rzucić kostkami jeszcze raz? (T/N): ").upper()
    if wybor == 'T':
        wyniki = rzuc_koscia(ilosc_rzutow)
        print("Wyniki rzutów:", wyniki)
        suma_punktow = sumuj_punkty(wyniki)
        print("Suma zdobytych punktów (tylko za oczka, które wystąpiły co najmniej 2 razy):", suma_punktow)
    elif wybor == 'N':
        break
    else:
        print("Niepoprawny wybór. Wpisz 'T' lub 'N'.")
 