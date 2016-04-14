/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package referencefinder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 *
 * @author ilucas
 */
public class StringFinder extends StringRegexAbstract {
    
     protected List<MatchFound> matchList = new ArrayList<MatchFound>();
    
    public StringFinder(String fileRegex, RegexConfig regexConfig, Charset fileEnconding) {
        super(fileRegex, regexConfig, fileEnconding);
        
    }
    
    public List<MatchFound> getMatchList() {
        return matchList;
    }
    
    @Override
    protected void matchFind(File f, int lineNumber, String line, Matcher matcher) {
        while (matcher.find()) {
            matchList.add(new MatchFound(f, lineNumber, line, matcher.start(), matcher.end(), matcher.group(groupExtract),regexConfig));
        }
    }
}
