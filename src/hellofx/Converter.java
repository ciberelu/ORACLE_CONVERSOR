package hellofx;

public class Converter {
    
    //tasas de cambio de dolar a otra moneda
    private static final double DOLAR_TO_DOLAR = 1;
    private static final double DOLAR_TO_QUETZAL = 7.85;
    private static final double DOLAR_TO_EURO = 0.94;
    private static final double DOLAR_TO_LIBRA_ESTERLINA = 0.82;
    private static final double DOLAR_TO_YEN_JAPONES = 148.28;
    private static final double DOLAR_TO_WON_SURCOREANO = 1335.66;



    //tasas de cambio de otra moneda a dolar

    private static final double QUETZAL_TO_DOLAR = 1 / DOLAR_TO_QUETZAL;
    private static final double EURO_TO_DOLAR = 1 / DOLAR_TO_EURO;
    private static final double LIBRA_ESTERLINA_TO_DOLAR = 1 / DOLAR_TO_LIBRA_ESTERLINA;
    private static final double YEN_JAPONES_TO_DOLAR = 1 / DOLAR_TO_YEN_JAPONES;
    private static final double WON_SURCOREANO_TO_DOLAR = 1 / DOLAR_TO_WON_SURCOREANO;

    


    public static Double convertir_To_Dolar(Double valorOriginal, Double unidadConversion){
        return valorOriginal * unidadConversion;
    }

    





    public static Double convertir(Double valorOriginal, Double unidadConversion, Double unidadConversionToDolar){
       
        Double resultadoEnDolares = convertir_To_Dolar(valorOriginal, unidadConversionToDolar);
        Double resultadoFinal = resultadoEnDolares * unidadConversion;
        return resultadoFinal;
    }

    public static  Double getTipoCambioToDolar(String moneda){
        if (moneda.equals("Dólar")){
            return DOLAR_TO_DOLAR;
        }else if (moneda.equals("Quetzal")){
            return QUETZAL_TO_DOLAR;
        }else if (moneda.equals("Euro")){
            return EURO_TO_DOLAR;
        }else if (moneda.equals("Yen")){
            return YEN_JAPONES_TO_DOLAR;
        }else if (moneda.equals("Libra esterlina")){
            return LIBRA_ESTERLINA_TO_DOLAR;
        }else if (moneda.equals("Won sul-coreano")){
            return WON_SURCOREANO_TO_DOLAR;
        }else {
            return 0.00;
        }
    }

    public static  Double getTipoCambioFromDolar(String moneda){
        if (moneda.equals("Dólar")){
            return DOLAR_TO_DOLAR;
        }else if (moneda.equals("Quetzal")){
            return DOLAR_TO_QUETZAL;
        }else if (moneda.equals("Euro")){
            return DOLAR_TO_EURO;
        }else if (moneda.equals("Yen")){
            return DOLAR_TO_YEN_JAPONES;
        }else if (moneda.equals("Libra esterlina")){
            return DOLAR_TO_LIBRA_ESTERLINA;
        }else if (moneda.equals("Won sul-coreano")){
            return DOLAR_TO_WON_SURCOREANO;
        }else {
            return 0.00;
        }
    }

    
}
