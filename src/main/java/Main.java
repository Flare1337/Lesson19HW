import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.TreeList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    static Gson gson = new Gson();

    public static void main(String[] args) {
        CallLog log = new CallLog(2019,"857342345", true);
        CallLog log2 = new CallLog(2018, "857342346", true);
        CallLog log3 = new CallLog(2016, "857342344", false);
        CallLog log4 = new CallLog(2009, "857342347", false);
        CallLog log5 = new CallLog(2007, "857342345", true);
        CallLog log6 = new CallLog(2016, "857342346", false);
        CallLog log7 = new CallLog(2015, "857342347", true);
        CallLog log8 = new CallLog(2021, "857342347", false);
        CallLog log9 = new CallLog(2020, "857342346", true);
        CallLog log10 = new CallLog(2010, "857342346", false);


        CallLog log11 = new CallLog(2000, "857342347", false);
        CallLog log12 = new CallLog(2077, "857342345", true);
        CallLog log13 = new CallLog(2022, "857342344", false);

        Collection<CallLog> callLogList = new ArrayList<>();

        callLogList.add(log);
        callLogList.add(log2);
        callLogList.add(log3);
        callLogList.add(log4);
        callLogList.add(log5);
        callLogList.add(log6);
        callLogList.add(log7);
        callLogList.add(log8);
        callLogList.add(log9);
        callLogList.add(log10);

        System.out.println("Задание №2");
        List<CallLog> treeList = new TreeList<>();
        treeList.addAll(callLogList);
        treeList.forEach(contact -> System.out.println(contact.toString()));

        System.out.println();

        FixedSizeList<CallLog> fixedSizeList = FixedSizeList.fixedSizeList(treeList);
        fixedSizeList.forEach(contact -> System.out.println(contact.toString()));
        TreeBidiMap<Integer, CallLog> contactTreeBidiMap = new TreeBidiMap<>();
        contactTreeBidiMap.put(1, log11);
        contactTreeBidiMap.put(10, log12);
        contactTreeBidiMap.put(5, log13);

        for (var contactEntry : contactTreeBidiMap.entrySet()) {
            System.out.println(contactEntry.getKey().toString());
            System.out.println(contactEntry.getValue().toString());
        }

        System.out.println();

        OrderedBidiMap<CallLog, Integer> reversedBidiMap = contactTreeBidiMap.inverseBidiMap();
        for (var contactEntry : reversedBidiMap.entrySet()) {
            System.out.println(contactEntry.getKey().toString());
            System.out.println(contactEntry.getValue().toString());
        }

        System.out.println("Задание №3");
        convertContactsToJSON(callLogList);
        callLogList = new ArrayList<>();
        System.out.println();
        convertContactsFromJSON(convertContactsToJSON(callLogList));

        System.out.println("Задания №5, 6, 7");
        System.out.println("Забыл что вы просили сделать это через копипасту поэтому оставлю оба варианта");

        Gson gson = new Gson();
        Collection<CallLog> callLogLis = List.of(new CallLog(2000, "857342347", false),
                new CallLog(2077, "857342345", true),
                new CallLog(2022, "857342344", false));
        String json = gson.toJson(callLogLis);

        System.out.println(json);
        Type collectionType = new TypeToken<Collection<CallLog>>(){}.getType();
        Collection<CallLog> contacts = gson.fromJson(json, collectionType);
        contacts.forEach(contact -> System.out.println(contact.toString()));
        System.out.println("Второй вариант");
        convertContactsFromJSON(convertContactsToJSON(createCallLogs(Integer.parseInt(args[0]))));
    }

    private static Collection<String> convertContactsToJSON(Collection<CallLog> contactList) {
        String json = "";
        Collection<String> callLogs = new ArrayList<>();
        for (CallLog contact : contactList) {
            json = gson.toJson(contact);
            System.out.println(json);
            callLogs.add(json);
        }
        return callLogs;
    }

    private static Collection<CallLog> convertContactsFromJSON(Collection<String> stringsList) {
        Collection<CallLog> callLogs = new ArrayList<>();
        for (String string : stringsList) {
            CallLog fromJson = gson.fromJson(string, CallLog.class);
            System.out.println(fromJson.toString());
            callLogs.add(fromJson);
        }
        return callLogs;
    }

    private static ArrayList<CallLog> createCallLogs(int sizeOfCollection) {
        if (sizeOfCollection < 0) {
            sizeOfCollection = 10;
        }
        CallLog log = new CallLog(2019,"857342345", true);
        CallLog log2 = new CallLog(2018, "857342346", true);
        CallLog log3 = new CallLog(2016, "857342344", false);
        CallLog log4 = new CallLog(2009, "857342347", false);
        CallLog log5 = new CallLog(2007, "857342345", true);
        CallLog log6 = new CallLog(2016, "857342346", false);
        CallLog log7 = new CallLog(2015, "857342347", true);
        CallLog log8 = new CallLog(2021, "857342347", false);
        CallLog log9 = new CallLog(2020, "857342346", true);
        CallLog log10 = new CallLog(2010, "857342346", false);

        ArrayList<CallLog> callLogs = new ArrayList<>();

        callLogs.add(log);
        callLogs.add(log2);
        callLogs.add(log3);
        callLogs.add(log4);
        callLogs.add(log5);
        callLogs.add(log6);
        callLogs.add(log7);
        callLogs.add(log8);
        callLogs.add(log9);
        callLogs.add(log10);

        ArrayList<CallLog> newCollection = new ArrayList<>();
        String[] phoneNumbers = new String[callLogs.size()];
        boolean[] isSuccessfulCalls = new boolean[callLogs.size()];
        int[] dates = new int[callLogs.size()];

        for (int counter = 0; counter < callLogs.size(); counter++) {
            phoneNumbers[counter] = callLogs.get(counter).getPhoneNumber();
            isSuccessfulCalls[counter] = callLogs.get(counter).isSuccessfulCall();
            dates[counter] = callLogs.get(counter).getDate();
        }

        for (int counter = 0; counter < sizeOfCollection; counter++) {
            int randomIndex = (int) (Math.random() * dates.length);
            int randomIndexTwo = (int) (Math.random() * phoneNumbers.length);
            int randomIndexThree = (int) (Math.random() * isSuccessfulCalls.length);
            newCollection.add(new CallLog(dates[randomIndex], phoneNumbers[randomIndexTwo], isSuccessfulCalls[randomIndexThree]));
        }
        return newCollection;
    }
}
