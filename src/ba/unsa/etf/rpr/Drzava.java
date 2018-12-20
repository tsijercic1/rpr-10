package ba.unsa.etf.rpr;

public class Drzava {
    private String naziv ;
    private Grad glavniGrad;

    public Drzava() {
    }

    public Drzava(String naziv, Grad glavniGrad) {
        this.naziv = naziv;
        this.glavniGrad = glavniGrad;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv=naziv;
    }

    public void setGlavniGrad(Grad grad) {
        this.glavniGrad=grad;
    }

//    @Override
//    public String toString() {
//        return naziv+ "  " + glavniGrad;
//    }
}
