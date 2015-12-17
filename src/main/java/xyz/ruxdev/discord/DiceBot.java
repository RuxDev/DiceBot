package xyz.ruxdev.discord;

/**
 * DiceBot - Chat Moderator and RPG Bot for Crit20Gaming
 * Copyright (c)2015
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.DiscordBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author Rux
 * @since 22:49 PM, 12/16/2015
 * Project: DiceBot
 */

public class DiceBot {
    String result = "";
    InputStream inputStream;

    public String getLogin() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "login.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(propFileName, " not found!");
            }

            Date time = new Date(System.currentTimeMillis());

            //get the login value and send
            String user = prop.getProperty("user");
            String pass = prop.getProperty("pass");

            DiscordAPI api = new DiscordBuilder(user, pass).build();
            api.login();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

}