package com.truecaller.network.models.remote

import com.truecaller.network.models.domain.Episode
import kotlinx.serialization.Serializable

@Serializable
data class RemoteEpisode(
		val id: Int, val name: String, val episode: String, val air_date: String, val characters: List<String>
) {
	override fun toString(): String {
		return "RemoteEpisode(id=$id, name='$name', episode='$episode', air_date='$air_date', characters=$characters)"
	}
}

fun RemoteEpisode.toDomainEpisode(): Episode {
	return Episode(id = id,
		name = name,
		seasonNumber = episode
			.filter { it.isDigit() }
			.take(2)
			.toInt(),
		episodeNumber = episode
			.filter { it.isDigit() }
			.takeLast(2)
			.toInt(),
		airDate = air_date,
		characterIdsInEpisode = characters.map {
			it
				.substring(startIndex = it.lastIndexOf("/") + 1)
				.toInt()
		})
}
