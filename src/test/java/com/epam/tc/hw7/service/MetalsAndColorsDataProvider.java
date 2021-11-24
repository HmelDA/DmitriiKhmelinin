package com.epam.tc.hw7.service;

import com.epam.tc.hw7.entities.MainContent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {
    private static final String METALS_AND_COLORS_TEST_DATA_PATH =
            "src/test/resources/com.epam.tc.hw7/JDImetalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColorsMainContent")
    public static Object[][] getDataFromJson()  {
        JsonObject metalsColorsMainContentData = null;
        try {
            metalsColorsMainContentData = JsonParser.parseReader(
                            new FileReader(METALS_AND_COLORS_TEST_DATA_PATH))
                    .getAsJsonObject();
        } catch (FileNotFoundException e) {
            System.err.println("No such Json file by" + METALS_AND_COLORS_TEST_DATA_PATH + "path.");
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonObject finalMetalsColorsMainContentData = metalsColorsMainContentData;

        return Objects.requireNonNull(metalsColorsMainContentData).keySet().stream()
                .map(key -> gson.fromJson(finalMetalsColorsMainContentData.get(key), MainContent.class))
                .map(value -> new MainContent[]{value})
                .toArray(Object[][]::new);
    }
}
