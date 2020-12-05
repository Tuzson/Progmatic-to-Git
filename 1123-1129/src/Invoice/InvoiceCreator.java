package Invoice;

public class InvoiceCreator {
    public static void main(String[] args) {
        invoiceTest(createInvoice());


    }
    public static Invoice createInvoice(){
        int randomAmount = (int)(Math.random()*500);
        return new Invoice(randomAmount);
        }

        public static void invoiceTest(Invoice invoice){
            boolean enoughMoney;
            for (int i = 0; i < 100; i++) {
                int random = (int)(Math.random()*2+1);
                if (random ==1){
                    int randomTakeIn= (int)(Math.random()*120);
                    invoice.takeIn(randomTakeIn);
                }
                else {
                    enoughMoney = false;
                    int randomTakeOut = (int)(Math.random()*250);
                    while (!enoughMoney) {
                        try {
                            invoice.takeOut(randomTakeOut);
                            enoughMoney = true;

                        } catch (NotEnoughMoneyException e) {
                                invoice.takeIn(100);
                                i++;
                        }
                    }
                }
            }
            System.out.println("Záró egyenleg: " + invoice.getActualAmount());
        }
    }
