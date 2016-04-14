/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package referencefinder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ilucas
 */
public abstract class StringRegexAbstract {

    public StringRegexAbstract(String fileRegex,RegexConfig regexConfig, Charset fileEnconding) {
        this.fileRegex = Pattern.compile(fileRegex);
        this.stringRegex = Pattern.compile(regexConfig.getStringRegex(), Pattern.CASE_INSENSITIVE);
        this.groupExtract = regexConfig.getGroupExtract();
        this.regexConfig= regexConfig;
        this.fileEnconding = fileEnconding;
    }
    protected Charset fileEnconding;
    protected Pattern fileRegex;
    protected RegexConfig regexConfig;
    protected int groupExtract;
    protected Pattern stringRegex;

    public void process(File x) {
        if (x.isDirectory()) {
            for (File f : x.listFiles()) {
                if (f.isDirectory()) {
                    process(f);
                }
                if (fileRegex.matcher(f.getName()).matches()) {
                    processFile(f);
                }
            }
        } else {
            processFile(x);
        }
    }

    protected void processFile(File f) {
        FileInputStream fileReader = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileInputStream(f);
            if (fileEnconding != null) {
                inputStreamReader = new InputStreamReader(fileReader, fileEnconding);
            } else {
                inputStreamReader = new InputStreamReader(fileReader);
            }
            bufferedReader = new BufferedReader(inputStreamReader);
            int lineNumber = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                ++lineNumber; //incrementar linha;
                Matcher matcher = stringRegex.matcher(line);
                matchFind(f, lineNumber, line, matcher);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringRegexAbstract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StringRegexAbstract.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringRegexAbstract.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(StringRegexAbstract.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    abstract void matchFind(File f, int lineNumber, String line, Matcher matcher);
}
