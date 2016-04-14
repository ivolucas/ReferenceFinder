/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package referencefinder;

import java.io.File;

/**
 *
 * @author ilucas
 */
public class MatchFound implements Comparable<MatchFound> {

    File file;
    int start;
    int end;
    int line;
    String lineText;
    String matched;
    RegexConfig regexConfig;
    
    
    
    public int getEnd() {
        return end;
    }
    
    public File getFile() {
        return file;
    }
    
    public String getMatched() {
        return matched;
    }
    
    public String getTrueText() {
        return lineText.substring(start, end);
    }
    
    public int getStart() {
        return start;
    }
    
    public int getLine() {
        return line;
    }
    
    public String getLineText() {
        return lineText;
    }
    
    public MatchFound(File file, int line, String lineText, int start, int end, String matched,RegexConfig regexConfig) {
        this.file = file;
        this.line = line;
        this.lineText = lineText;
        this.start = start;
        this.end = end;
        this.matched = matched;
        this.regexConfig = regexConfig;        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatchFound other = (MatchFound) obj;
        if (this.file != other.file && (this.file == null || !this.file.equals(other.file))) {
            return false;
        }
        if (this.start != other.start) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        if (this.line != other.line) {
            return false;
        }
        if ((this.lineText == null) ? (other.lineText != null) : !this.lineText.equals(other.lineText)) {
            return false;
        }
        if ((this.matched == null) ? (other.matched != null) : !this.matched.equals(other.matched)) {
            return false;
        }
        if (this.regexConfig != other.regexConfig && (this.regexConfig == null || !this.regexConfig.equals(other.regexConfig))) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.file != null ? this.file.hashCode() : 0);
        hash = 53 * hash + this.start;
        hash = 53 * hash + this.end;
        hash = 53 * hash + this.line;
        hash = 53 * hash + (this.lineText != null ? this.lineText.hashCode() : 0);
        hash = 53 * hash + (this.matched != null ? this.matched.hashCode() : 0);
        hash = 53 * hash + (this.regexConfig != null ? this.regexConfig.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(MatchFound o) {
        int compare = 0;
        if ((compare =this.file.compareTo(o.file) )!=0) {
            return compare;
        }
        if ((compare =regexConfig.description.compareTo(o.regexConfig.description) )!=0){
            return compare;
        } 
        if ((compare =this.matched.compareTo(o.matched) )!=0) {
            return compare;
        }
        if ((compare =this.line -o.line )!=0) {
            return compare;
        }
        if ((compare =this.start -o.start )!=0) {
            return compare;
        }
        if ((compare =this.end -o.end )!=0) {
            return compare;
        }
        if ((compare =this.lineText.compareTo(o.lineText) )!=0) {
            return compare;
        }
        if (regexConfig.equals(o.regexConfig)){
            return 0;
        } else {
            return 1;
        }
        
        
        
    }
    
    
}
