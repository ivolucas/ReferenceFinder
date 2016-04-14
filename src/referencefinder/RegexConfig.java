/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package referencefinder;

import java.io.Serializable;

/**
 *
 * @author ilucas
 */
public class RegexConfig implements Serializable {

    String stringRegex;
    int groupExtract;
    String description;

    public int getGroupExtract() {
        return groupExtract;
    }

    public void setGroupExtract(int groupExtract) {
        this.groupExtract = groupExtract;
    }

    public String getStringRegex() {
        return stringRegex;
    }

    public void setStringRegex(String stringRegex) {
        this.stringRegex = stringRegex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RegexConfig(String stringRegex, int groupExtract, String description) {
        this.stringRegex = stringRegex;
        this.groupExtract = groupExtract;
        this.description = description;
    }


}
