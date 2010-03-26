/*
 *  Copyright 2010 Ryszard Wiśniewski <brut.alll@gmail.com>.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package brut.directory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
public class DirUtil {
    public static void copyFiles(Directory in, Directory out)
            throws DirectoryException {
        for (String fileName : in.getFiles(true)) {
            InputStream inStream = in.getFileInput(fileName);
            OutputStream outStream = out.getFileOutput(fileName);
            try {
                IOUtils.copy(inStream, outStream);
            } catch (IOException ex) {
                throw new DirectoryException(ex);
            } finally {
                try {
                    inStream.close();
                    outStream.close();
                } catch (IOException ex) {}
            }
        }
    }
}
