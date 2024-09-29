package com.mygoal.dataprovider;

import org.testng.annotations.DataProvider;

import com.mygoal.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		int rows = obj.getRowCount("Credentials");
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

}