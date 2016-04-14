/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package referencefinder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ilucas
 */
public class Configuration implements Serializable{
    
    String workFolder="";
    String fileRegex="";
    String bundleFile="";
     String encoding="";
    List<RegexConfig> regexConfigs = new ArrayList<RegexConfig>();

    public String getWorkFolder() {
        return workFolder;
    }

    public void setWorkFolder(String workFolder) {
        this.workFolder = workFolder;
    }

    public String getFileRegex() {
        return fileRegex;
    }

    public void setFileRegex(String fileRegex) {
        this.fileRegex = fileRegex;
    }

    public String getBundleFile() {
        return bundleFile;
    }

    public void setBundleFile(String bundleFile) {
        this.bundleFile = bundleFile;
    }

    public List<RegexConfig> getRegexConfigs() {
        return regexConfigs;
    }

    public void setRegexConfigs(List<RegexConfig> regexConfigs) {
        this.regexConfigs = regexConfigs;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    
}
