package by.etc.firsttask.repository;

import by.etc.firsttask.entity.Quadrangle;

public class NotifyEventArgs {
    private RepositoryEntryStatus status;
    private Quadrangle quadrangle;

    public NotifyEventArgs(Quadrangle quadrangle, RepositoryEntryStatus status) {
        this.quadrangle = quadrangle;
        this.status = status;
    }

    public Quadrangle getQuadrangle() {
        return quadrangle;
    }

    public void setQuadrangle(Quadrangle quadrangle) {
        this.quadrangle = quadrangle;
    }

    public RepositoryEntryStatus getStatus() {
        return status;
    }

    public void setStatus(RepositoryEntryStatus status) {
        this.status = status;
    }
}
