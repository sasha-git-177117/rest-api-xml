package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseAnswer {
    GET_BOOKS("catalog.book"),
    GET_ID("id");

    public final String label;
}
