import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
    StudentAnalyzer analyzer = new StudentAnalyzer();
    @Test
    public void testNormalCase() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testAllValid() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0, 7.5);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testBoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testInvalidValues() {
        List<Double> scores = Arrays.asList(-5.0, 12.0, 9.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testAverageNormalCase() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testAverageAllValid() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0);
        assertEquals(9.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testAverageEmpty() {
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testAverageBoundary() {
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testAverageInvalidValues() {
        List<Double> scores = Arrays.asList(-2.0, 15.0);
        assertEquals(0, analyzer.calculateValidAverage(scores), 0.01);
    }
}
