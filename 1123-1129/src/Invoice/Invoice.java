package Invoice;

public class Invoice {

    private int actualAmount;


    public Invoice(int actualAmount) {
        this.actualAmount = actualAmount;

    }


    public void takeIn(int amount) {

        try {
            if (amount < 1) {
                throw new InvalidMoneyInputException();
            } else if (amount > 100) {
                throw new TooBigAmountException();
            } else {
                actualAmount += amount;
                System.out.println("Sikeres pénzbefizetés.");
            }

        } catch (InvalidMoneyInputException e) {
            System.out.println("A betenni kívánt összeg 0 vagy annál kisebb. Kérés nem teljesíthető");
        } catch (TooBigAmountException e) {
            System.out.println("A betenni kívánt összeg 100-nál nagyobb. Kérés nem teljesíthető");
        }

    }

    public void takeOut(int amount) throws NotEnoughMoneyException {

        try {
            if (amount < 1) {
                throw new InvalidMoneyInputException();
            } else if (amount > 200) {
                throw new TooBigAmountException();
            } else if (actualAmount - amount < 0) {
                System.out.println("A kivenni kívánt összeg több mint amennyi az egyenlege. A hiányzó összeg: " + Math.abs(actualAmount - amount));
                throw new NotEnoughMoneyException();

            } else {
                actualAmount -= amount;
                System.out.println("Sikeres pénzkivétel.");
            }

        } catch (InvalidMoneyInputException e) {
            System.out.println("A kivenni kívánt összeg 0 vagy annál kisebb. Kérés nem teljesíthető");
        } catch (TooBigAmountException e) {
            System.out.println("A kivenni kívánt összeg 200-nál nagyobb. Kérés nem teljesíthető");
        }

    }

    public int getActualAmount() {
        return actualAmount;
    }
}

