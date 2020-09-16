/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mjw.hello.concurrency.jcc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 19 Jan 2019, 1:40 PM
 */
public class TaskValidator implements Callable<String>
{
    public static void main(String[] args)
    {
        String userName = "test";
        String passwork = "test";
        UserValidator ldap = new UserValidator("LDAP");
        UserValidator db = new UserValidator("DataBase");
        TaskValidator ldapTask = new TaskValidator(ldap, userName, passwork);
        TaskValidator dbTask = new TaskValidator(db, userName, passwork);

        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);
        ExecutorService executor = Executors.newCachedThreadPool();
        String result;
        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.print("Main: End of the Execution\n");
    }

    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password)
    {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override public String call() throws Exception
    {
        if (!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: THe user has been found\n", validator.getName());
        return validator.getName();
    }
}
