# Activitat 06 - Espera Wait

## 1. Per què s'atura l'execució al cap d'un temps?
Perque tots els fils estan esperant una notificacio.


## 2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% (cancel·lar)? I si foren al revés les probabilitats?      

### Probabilitat 70% ferReserva - 30% cancel·lar   

Si la possibilitat és més alta, estaran tots esperant més ràpidament.
```java
public void run() {
        while (true) {
            try {
                if (random.nextInt(100) <= 70) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
```
### Probabilitat 30% ferReserva - 70% cancel·lar   

Si és més baixa costaria més que totes estiguin esperant.
```java
public void run() {
        while (true) {
            try {
                if (random.nextInt(100) <=30) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
```

## 3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?    

Per poder tenir múltiples reserves i poder afegir-ne i eliminar-ne més forma més còmoda.