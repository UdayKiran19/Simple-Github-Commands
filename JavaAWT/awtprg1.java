import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class awtprg1 extends JFrame implements ActionListener {

    private JTextField amountField;
    private JComboBox<String> fromCurrency, toCurrency;
    private JLabel resultLabel;
    private JButton convertButton, closeButton;
    private Map<String, Double> exchangeRates;

    public awtprg1() {
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Initialize exchange rates (you can update this with real-time rates)
        exchangeRates = new HashMap<>();
        exchangeRates.put("INR", 1.0);
        exchangeRates.put("USD", 0.014);
        exchangeRates.put("EUR", 0.012);
        exchangeRates.put("YEN", 1.829);
        exchangeRates.put("GBP", 0.009);
        exchangeRates.put("CAD", 0.016);
        exchangeRates.put("CHF", 0.010);
        exchangeRates.put("SGD", 0.017);
        exchangeRates.put("CNY", 0.084);
        exchangeRates.put("MYR", 0.052);
        // Add more currencies and their exchange rates as needed

        // Create UI components
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JLabel fromLabel = new JLabel("From Currency:");
        String[] currencies = exchangeRates.keySet().toArray(new String[0]);
        fromCurrency = new JComboBox<>(currencies);

        JLabel toLabel = new JLabel("To Currency:");
        toCurrency = new JComboBox<>(currencies);

        resultLabel = new JLabel();

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        // Add components to the frame
        add(amountLabel);
        add(amountField);
        add(fromLabel);
        add(fromCurrency);
        add(toLabel);
        add(toCurrency);
        add(convertButton);
        add(resultLabel);
        add(closeButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();

                double result = amount * exchangeRates.get(to) / exchangeRates.get(from);
                resultLabel.setText("Result: " + result + " " + to);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount");
            }
        } else if (e.getSource() == closeButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new awtprg1();
    }
}