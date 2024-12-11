package org.example.potokilaba.lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.potokilaba.lab1.RunnableIntegralCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IntegralController {

    @FXML
    public TextField nThreads;
    @FXML
    public TextField n;
    @FXML
    public TextArea resultField;

    StringBuilder sb = new StringBuilder();

    private double a = Math.PI/6;
    private double b = Math.PI/4;
    private double totalResult;


    public void calculateButton(ActionEvent actionEvent) {
        int numThreads = Integer.parseInt(nThreads.getText());
        int N = Integer.parseInt(n.getText());

        totalResult = 0;

        double delta = (b - a) / numThreads;
        int nSteps = N / numThreads;

        long startTime = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Double>> futures = new ArrayList<>();


        for (int i = 0; i < numThreads; i++) {
            CallableIntegralCalculator calculator = new CallableIntegralCalculator(a + i * delta, a + i * delta + delta,
                    nSteps, t -> 1 / Math.pow(Math.sin(2 * t), 2));
            futures.add(executor.submit(calculator)); // Submit and store Future
        }

        try {
            for (Future<Double> future : futures) {
                totalResult += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("An error occurred during execution", e);
        } finally {
            executor.shutdown();
        }

        long finishTime = System.nanoTime();


        sb.append("Number of threads: ").append(numThreads).append("\n")
                .append("Number of steps (n): ").append(N).append("\n")
                .append("Result: ").append(totalResult).append("\n")
                .append(String.format("Execution time: %.5f ms\n", (finishTime - startTime) / 1e6)).append("\n");
        resultField.setText(sb.toString());
    }


}