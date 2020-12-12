package pl.paweln.dp.structural.composite;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.composite.neurons.Neuron;
import pl.paweln.dp.structural.composite.neurons.NeuronLayer;

public class NeuronTest {
    private static Logger logger = LoggerFactory.getLogger(NeuronTest.class);


    @Test
    public void testNeuronLayersTest() {

        logger.info("Neuron test ...");

        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer layer = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();
        layer.add(new Neuron());
        layer2.add(new Neuron());
        layer2.add(new Neuron());

        neuron.connectTo(neuron2);
        neuron.connectTo(layer);
        layer.connectTo(neuron);
        layer.connectTo(layer2);

        Assert.assertEquals(2, neuron.out.size());
        Assert.assertEquals(1, neuron.in.size());

        Assert.assertEquals(0, neuron2.out.size());
        Assert.assertEquals(1, neuron2.in.size());




    }
}
