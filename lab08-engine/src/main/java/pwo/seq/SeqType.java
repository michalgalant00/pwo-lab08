package pwo.seq;

import java.util.stream.Stream;

public enum SeqType {

    FIB, //Fibonacci
    LUC, //Lucas
    TRI; //Tribonacci

    private static final int B = 0, L = 3;
    private static final String FIX_SEQTYPE
            = "Problem in " + SeqType.class.getName();

    static {
        Stream.of(SeqType.values()).forEach(t -> {
            if (t.toString().length() != L) {
                throw new IllegalStateException(FIX_SEQTYPE);
            }
        });
    }

    public static SeqType fromString(String type) {
        try {
            return valueOf(type.trim()
                    .substring(B, L).toUpperCase());
        } catch (NullPointerException
                | StringIndexOutOfBoundsException
                | IllegalArgumentException ex) {
            return null;
        }
    }

    public Generator getGenerator() {
        switch (this) {
            case FIB:
                return new FibonacciGenerator();
            case LUC:
                return new LucasGenerator();
            case TRI:
                return new TribonacciGenerator();
            default:
                throw new IllegalStateException(FIX_SEQTYPE);
        }
    }
}
