/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
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

package test.jdk.util.stream;

import org.junit.jupiter.api.Test;
import test.jdk.lambda.Album;
import test.jdk.lambda.Artist;
import test.jdk.lambda.SampleData;
import test.jdk.lambda.Track;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 07 2016, 19:13
 */
public class StreamTest {

    @Test void testFilter() {

        List<Artist> allArtists = SampleData.membersOfTheBeatles;
        // 该语句实际上什么都没做，如果运行该实例，则没有任何输出，懒惰初始化
        allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        });

        // 由于调用了
        long count = allArtists.stream().filter(artist -> {
            // System.out.println(artist.getName());
            return artist.isFrom("London");
        }).count();
    }

    /**
     * collect(toList()) is an eager operation that generates a list from the
     * values in a Stream.
     */
    @Test
    public void testCollect() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), collected);
    }

    /**
     * 可以将一种类型转换为另一种类型
     */
    @Test
    public void testMap() {
        List<String> collected = Stream.of("A", "b", "hello").map(String::toUpperCase)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testFilter2() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }

        assertEquals(Collections.singletonList("1abc"), beginningWithNumbers);

        List<String> beginningWithNumbers2 = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
        assertEquals(Collections.singletonList("1abc"), beginningWithNumbers2);
    }

    /**
     * flatMap lets you replace a value with a Stream and concatenates all the
     * streams together.
     */
    @Test
    public void testFlatMap() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(Collection::stream).collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }

    @Test
    public void testMax() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream().min(Comparator.comparing(Track::getLength)).get();
        assertEquals(tracks.get(1), shortestTrack);
    }

    @Test
    public void testReduce() {
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);
    }

    @Test
    public void test() {
        Set<String> origins = SampleData.manyTrackAlbum.getMusicians()
                .filter(artist -> artist.getName().startsWith("The")).map(Artist::getNationality)
                .collect(Collectors.toSet());

    }

    @Test
    public void test2() {

    }

    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            album.getTrackList().stream().filter(track -> track.getLength() > 60).forEach(track -> {
                String name = track.getName();
                trackNames.add(name);
            });
        }
        return trackNames;
    }

    public Set<String> findLongTracks2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> album.getTracks().forEach(track -> {
            if (track.getLength() > 60) {
                String name = track.getName();
                trackNames.add(name);
            }
        }));

        return trackNames;
    }

    public Set<String> findLongTracks3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream().forEach(album -> album.getTracks().filter(track -> track.getLength() > 60).map(Track::getName)
                .forEach(trackNames::add));

        return trackNames;
    }

    public Set<String> findLongTracks4(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .forEach(trackNames::add);
        return trackNames;
    }
}
