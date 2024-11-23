package L6;

import java.util.Objects;
import lombok.NonNull;

public class RequestForCarInspection {
    private @NonNull int id;
    private @NonNull String title;
    private @NonNull Client client;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RequestForCarInspection that = (RequestForCarInspection)o;
            return this.id == that.id && this.title.equals(that.title) && this.client.equals(that.client);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.title, this.client});
    }

    public @NonNull int getId() {
        return this.id;
    }

    public @NonNull String getTitle() {
        return this.title;
    }

    public @NonNull Client getClient() {
        return this.client;
    }

    public RequestForCarInspection setId(@NonNull int id) {
        this.id = id;
        return this;
    }

    public RequestForCarInspection setTitle(@NonNull String title) {
        if (title == null) {
            throw new NullPointerException("title is marked non-null but is null");
        } else {
            this.title = title;
            return this;
        }
    }

    public RequestForCarInspection setClient(@NonNull Client client) {
        if (client == null) {
            throw new NullPointerException("client is marked non-null but is null");
        } else {
            this.client = client;
            return this;
        }
    }

    public String toString() {
        int var10000 = this.getId();
        return "RequestForCarInspection(id=" + var10000 + ", title=" + this.getTitle() + ", client=" + String.valueOf(this.getClient()) + ")";
    }

    public RequestForCarInspection() {
    }
}