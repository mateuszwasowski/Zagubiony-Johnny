# Zagubiony Johnny
*Autorzy: Mateusz Wąsowski, Patryk Wylegała, Paweł Wasilczyk*  


#### Opis projektu

Zagubiony Johnny jest grą tekstową, w której tytułowy bohater (agent) porusza się po planszy złożonej z układu pomieszczeń (tablica dwuwymiarowa, z której usunięto niektóre pola). Celem agenta jest dotarcie do pokoju, w którym mieszczą się drzwi prowadzące na zewnątrz budynku. Pokój początkowy oraz końcowy jest ustalony jednoznacznie. Agent jest punktem zorientowanym (rozróżniamy jego przód i tył oraz stronę lewą i prawą), którego ruch odbywa się w czterech kierunkach. 

Wejście programu stanowią polecenia tekstowe wpisywane w języku polskim, za pomocą których użytkownik komunikuje się z zagubionym bohaterem. Ponadto, gracz ma możliwość śledzenia losów agenta dzięki wizualizacji jego aktualnego położenia na planszy, a także okna podglądu pomieszczeń (monitoring w budynku). W odpowiedzi na komendy użytkownika, agent wykonuje zadane polecenia lub informuje o napotykanych utrudnieniach (np. brak możliwości ruchu w danym kierunku, zamknięte drzwi).

Główną przeszkodę dla bohatera stanowią pomieszczenia, do których nie można wejść bez klucza (na mapie oznaczono je kolorem czerwonym, niebieskim i zielonym). Aby zdobyć klucze, należy przeprowadzić komunikację agenta z trzema strażnikami i odpowiedzieć na zadawane przez nich pytania. Strażnicy generowani są w losowych lokalizacjach – każdy z nich na kilka możliwych sposobów.

Zakończenie gry następuje po wyjściu na zewnątrz z ostatniego pomieszczenia lub w przypadku udzielenia nieprawidłowych odpowiedzi w rozmowie ze strażnikami.

Projekt został napisany w języku Java, a jego interfejs graficzny zrealizowano w oparciu o bibliotekę Swing.


#### Funkcjonalność

**Mateusz Wąsowski** – cała grafika, stworzenie klas komendy oraz przetwarzania wprowadzanego tekstu aby móc go zastosować w kodzie. Stworzenie klasy strażnika, randomizacja ich pojawiania się na mapie, możliwości otrzymywania kluczy od każdego z nich. Komunikacja ze strażnikami, poprzez zagadki (również losowe) i odpowiedzi. Poprawianie różnych błędów przemieszczenia się Johnnego.

**Patryk Wylegała** – zrobienie szkieletu menu, w tym ułożenie przycisków, wymiary okna itd. Zaimplementowanie muzyki (i sterowanie nią). Zrobienie konsoli w grze, która sczytuje polecenia użytkownika po enterze i zapisuje do zmiennej. Poszerzenie słownictwa w komendach oraz w ogólnej komunikacji (Johnny – Strażnik – Hacker). Ogólna wizualizacja i czytelność kodu.

**Paweł Wasilczyk** – krata dla agenta, mechanizm poruszania się z uwzględnieniem ograniczeń (niedostępne kierunki) oraz aktualnej orientacji (obrót co 90 stopni), wizualizacja obecnego stanu na planszy (kolorem żółtym oznaczono pozycję agenta, a fioletowym aktualnie wyświetlany pokój).

*Elementy, których nie wymieniono powyżej, są efektem wspólnej pracy członków zespołu.*
