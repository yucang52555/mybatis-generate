package com.kfx.xsb.mybatis;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.internal.util.StringUtility;
import org.mybatis.generator.internal.util.messages.Messages;

public class RenameMybatorPlugin extends PluginAdapter {
	private String searchString;
	private String replaceString;
	private Pattern pattern;

	public boolean validate(List<String> warnings) {
		this.searchString = this.properties.getProperty("searchString");
		this.replaceString = this.properties.getProperty("replaceString");

		boolean valid = (StringUtility.stringHasValue(this.searchString))
				&& (StringUtility.stringHasValue(this.replaceString));

		if (valid) {
			this.pattern = Pattern.compile(this.searchString);
		} else {
			if (!StringUtility.stringHasValue(this.searchString)) {
				warnings.add(Messages.getString("ValidationError.18",
						"RenameExampleClassPlugin", "searchString"));
			}

			if (!StringUtility.stringHasValue(this.replaceString)) {
				warnings.add(Messages.getString("ValidationError.18",
						"RenameExampleClassPlugin", "replaceString"));
			}

		}

		return valid;
	}

	public void initialized(IntrospectedTable introspectedTable) {
		String oldType = introspectedTable.getExampleType();
		Matcher matcher = this.pattern.matcher(oldType);
		oldType = matcher.replaceAll(this.replaceString);

		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		for(IntrospectedColumn column : columns){
			String[] tmp = column.getJavaProperty().split("_");
			StringBuffer sb = new StringBuffer(tmp[0]);
			for(int i = 1; i < tmp.length; i++){
				sb.append(new StringBuffer()
	            .append(tmp[i].substring(0, 1).toUpperCase())
	            .append(tmp[i].substring(1))
	            .toString());
			}
			column.setJavaProperty(sb.toString());
		}
		
		introspectedTable.setExampleType(oldType);
	}
}