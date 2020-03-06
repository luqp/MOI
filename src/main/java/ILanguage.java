/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

/**
 * This interface defines the type of object for the classes that implement it will use
 */
public interface ILanguage {
    /**
     * @param params whit this object this method will receive its parameters
     * @return a string that will use another class in charge of execute commands
     */
    String commandBuilder(Params params);
}
