# esercizi-neosperience

## Fase 1
utilizzo file jar:<br />
```
java -jar Fase1.jar <n>
```
verrà restuito l'indice del primo numero con n cifre nella sequence di Fibonacci

## Fase 2
la classe Student è inclusa assieme alla Fase 3

## Fase 3
### salvataggio di un nuovo studente:
    curl -X POST localhost:8080/createstudent 
        -H "Content-type:application/json" 
        -d  "{\"firstname\": \"Sebastian\", \"lastname\": \"Vettel\", \"birthdate\": \"1987-07-03\", \"grades\": [25, 28, 30, 21, 18]}"
### lista degli studenti:
    curl localhost:8080/getstudents 
