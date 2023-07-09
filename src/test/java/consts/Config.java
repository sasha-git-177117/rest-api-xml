package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Config {
    CONFIG_DATA_PATH("src/test/resources/config.json"),
    BASE_URI("baseURI");

    public final String label;
}
