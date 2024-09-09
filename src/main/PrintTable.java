package main;

import java.util.ArrayList;

public class PrintTable {
    public static void printTable(ArrayList<String> headings, ArrayList<ArrayList<String>> data) {
        String[] headers = new String[headings.size()] ;

        headers = headings.toArray(headers);

        String[][] rows = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        // Calculate column widths
        int[] columnWidths = calculateColumnWidths(headers, rows);

        // Print the header
        printRow(headers, columnWidths);
        printSeparator(columnWidths);

        // Print each row of the table
        for (String[] row : rows) {
            printRow(row, columnWidths);
        }
    }

    // Method to calculate the column widths based on headers and rows
    private static int[] calculateColumnWidths(String[] headers, String[][] rows) {
        int[] columnWidths = new int[headers.length];

        // Set initial widths based on headers
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }

        // Adjust widths based on row data
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
        }

        return columnWidths;
    }

    // Method to print a single row of the table
    private static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            // %-Ns means left-align to N characters wide, where N is the column width
            System.out.printf("%-" + columnWidths[i] + "s ", row[i]);
        }
        System.out.println(); // Move to the next line after printing the row
    }

    // Method to print a separator line
    private static void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            // Print dashes equal to the width of the column plus one space for padding
            for (int i = 0; i < width + 1; i++) {
                System.out.print("-");
            }
        }
        System.out.println(); // Move to the next line after printing the separator
    }
}
