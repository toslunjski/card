package com.ts.cardapp.core.service;

import com.ts.cardapp.core.model.InternalCandidate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@Service
public class InternalFileService
{
    private static final String DELIMITER = ";";

    public boolean createFile(final InternalCandidate internalCandidate)
    {
        makeFile(internalCandidate);

        writeToFile(internalCandidate);

        return true;
    }

    private static void writeToFile(final InternalCandidate internalCandidate)
    {
        try {
            FileWriter myWriter = new FileWriter(internalCandidate.getOib() + ".txt");
            myWriter.write(internalCandidate.getName() + DELIMITER + internalCandidate.getSurname() + DELIMITER + internalCandidate.getOib() + DELIMITER + internalCandidate.getSurname());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void makeFile(final InternalCandidate internalCandidate)
    {
        try {
            File file = new File(internalCandidate.getOib() + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean checkFileExists(final long oib)
    {
        return new File(oib + ".txt").isFile();
    }
    public boolean deleteFile(final long oib)
    {
        return false;
    }
}