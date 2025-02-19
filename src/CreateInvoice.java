public interface CreateInvoice {
    void CreateInvoice(order order);//dip
}


//json format invoice extends create invoice {//logic }:
//cvs extends create invoice class{//logic }
//this follow dip : as does not depend on concrete classd
// ,lsp: any child class of create invoice can replace create invoice
// ,ocp:can be extend
// ,srp: as doing one type work and maintain cohesion