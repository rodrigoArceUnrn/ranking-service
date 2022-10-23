package ar.edu.unrn.rankingservice.exception;

public class RankingUnknownException extends Throwable {
    public RankingUnknownException(String message) {
        super(message);
    }

    public RankingUnknownException() {
        super();
    }
}
