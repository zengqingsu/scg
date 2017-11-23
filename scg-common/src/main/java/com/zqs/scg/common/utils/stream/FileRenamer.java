package com.zqs.scg.common.utils.stream;

import com.zqs.scg.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * An interface to provide a pluggable file renaming policy, particularly
 * useful to handle naming conflicts with an existing file.
 *
 * @author Jason Hunter
 * @version 1.0, 2002/04/30, initial revision, thanks to Changshin Lee for
 *          the basic idea
 */
public abstract class FileRenamer {
  private static final Logger logger = LoggerFactory.getLogger(FileRenamer.class);
  public final static FileRenamer RENAMER;

  static {
    FileRenamer fileRenamer = null;
    if (Constant.fileRenamer == null) {
      fileRenamer = new DefaultFileRenamer();
    } else {
      try {
        Class renameClass = Class.forName(Constant.fileRenamer);
        fileRenamer = (FileRenamer) renameClass.newInstance();
      } catch (ClassNotFoundException e) {
        logger.error("Could not found FileRenamer Class." + e.toString());
      } catch (InstantiationException e) {
        logger.error("Could not init FileRenamer Class." + e.toString());
      } catch (IllegalAccessException e) {
        logger.error("Could not access FileRenamer Class." + e.toString());
      }
    }
    RENAMER = fileRenamer;
  }

  /**
   * Returns a File object holding a new name for the specified file.
   */
  public abstract File rename(File f);


  protected boolean createNewFile(File f) {
    try {
      return f.createNewFile();
    } catch (IOException ignored) {
      return false;
    }
  }
}
