package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MetalsAndColors extends DataClass<MetalsAndColors> {

    private final List<Integer> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;

    public MetalsAndColors(List<Integer> summary, List<String> elements,
                           String color, String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public String getSummaryStringValue(int index) {
        return summary.get(index).toString();
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MetalsAndColors that = (MetalsAndColors) o;
        return Objects.equals(summary, that.summary)
                && Objects.equals(elements, that.elements)
                && Objects.equals(color, that.color)
                && Objects.equals(metals, that.metals)
                && Objects.equals(vegetables, that.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), summary, elements, color, metals, vegetables);
    }

    @Override
    public String toString() {
        return "MetalsAndColors{"
                 + "summary=" + summary
                 + ", elements=" + elements
                 + ", color='" + color + '\''
                 + ", metals='" + metals + '\''
                 + ", vegetables=" + vegetables
                 + '}';
    }

    public List<String> testExpectedResults() {
        return Arrays.asList(
                "Summary: " + summary.stream()
                .mapToInt(Integer::intValue).sum(),
                "Elements: " + elements.stream()
                        .map(Object::toString)
                .collect(Collectors.joining(", ")),
                "Color: " + getColor(),
                "Metal: " + getMetals(),
                "Vegetables: " + vegetables.stream()
                        .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}
