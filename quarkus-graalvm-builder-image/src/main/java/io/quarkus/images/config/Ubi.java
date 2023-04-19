package io.quarkus.images.config;

import com.google.common.collect.Maps;

import java.util.Map;

public class Ubi {
  public final Release defaultRelease;
  public final Map<Release, String> images;

  public Ubi(int defaultRelease, String ubi8, String ubi9) {
    this.defaultRelease = Release.from(defaultRelease);
    this.images = Maps.immutableEnumMap(Map.of(
      Release.UBI8, ubi8,
      Release.UBI9, ubi9
    ));
  }

  public enum Release {
    UBI8(8),
    UBI9(9);

    public final int num;

    Release(int num) {
      this.num = num;
    }

    public static Release from(int num) {
      for (Release r : values()) {
        if (r.num == num) {
          return r;
        }
      }
      throw new IllegalArgumentException("No release for " + num);
    }
  }
}
