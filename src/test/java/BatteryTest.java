import com.example.rangeestimatoremobility.Battery;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BatteryTest {
    private Battery battery;

    @Before
    public void setUp() {
        battery = new Battery(100, 80, 200);
    }

    @Test
    public void testGetRemainingEnergy() {
        double expectedRemainingEnergy = 80;
        assertEquals(expectedRemainingEnergy, battery.getRemainingEnergy(), 0.01);
    }

    @Test
    public void testEstimateRange() {
        double energyConsumption = 200;
        double expectedRange = battery.getRemainingEnergy() / energyConsumption * 1000;
        assertEquals(expectedRange, battery.estimateRange(energyConsumption), 0.01);
    }

    @Test
    public void testEstimateRange_zeroEnergyConsumption() {
        double energyConsumption = 0;
        double expectedRange = Double.POSITIVE_INFINITY;
        assertEquals(expectedRange, battery.estimateRange(energyConsumption), 0.01);
    }

    @Test
    public void testEstimateRange_highEnergyConsumption() {
        double energyConsumption = 800;
        double expectedRange = battery.getRemainingEnergy() / energyConsumption * 1000;
        assertEquals(expectedRange, battery.estimateRange(energyConsumption), 0.01);
    }

    @Test
    public void testEstimateRange_negativeEnergyConsumption() {
        double energyConsumption = -200;
        double expectedRange = Double.NaN;
        assertEquals(expectedRange, battery.estimateRange(energyConsumption), 0.01);
    }

    @Test
    public void testEstimateRange_differentDischargeRate() {
        battery.setDischargeRate(250);
        double energyConsumption = 250;
        double expectedRange = battery.getRemainingEnergy() / energyConsumption * 1000;
        assertEquals(expectedRange, battery.estimateRange(energyConsumption), 0.01);
    }
}
