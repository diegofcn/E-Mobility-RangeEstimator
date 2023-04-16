import com.example.rangeestimatoremobility.DrivingConditions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DrivingConditionsTest {
    private DrivingConditions conditions;

    @Before
    public void setUp() {
        conditions = new DrivingConditions("sunny", "flat", "light");
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_sunny_flat_light() {
        double expectedFactor = 1.0;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.01);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_rainy_flat_light() {
        conditions.setWeather("rainy");
        double expectedFactor = 1.1;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.01);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_sunny_uphill_light() {
        conditions.setRoadCondition("uphill");
        double expectedFactor = 1.2;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.01);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_sunny_flat_heavy() {
        conditions.setTrafficCondition("heavy");
        double expectedFactor = 1.1;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.01);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_rainy_uphill_light() {
        conditions.setWeather("rainy");
        conditions.setRoadCondition("uphill");
        double expectedFactor = 1.3;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.1);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_rainy_flat_heavy() {
        conditions.setWeather("rainy");
        conditions.setTrafficCondition("heavy");
        double expectedFactor = 1.2;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.1);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_sunny_uphill_heavy() {
        conditions.setRoadCondition("uphill");
        conditions.setTrafficCondition("heavy");
        double expectedFactor = 1.3;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.1);
    }

    @Test
    public void testGetEnergyConsumptionAdjustmentFactor_rainy_uphill_heavy() {
        conditions.setWeather("rainy");
        conditions.setRoadCondition("uphill");
        conditions.setTrafficCondition("heavy");
        double expectedFactor = 1.4;
        assertEquals(expectedFactor, conditions.getEnergyConsumptionAdjustmentFactor(), 0.1);
    }
}
