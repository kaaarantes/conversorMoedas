package principal;

public record DadosMoeda(String base_code, String target_code, double conversion_result) {
    @Override
    public String toString() {
        return String.valueOf(conversion_result);
    }
}

