package com.truecaller.network.models.domain

data class Character(
	val created: String, val episodeIds: List<Int>,
	val gender: CharacterGender,
	val id: Int,
	val imageUrl: String,
	val location: Location,
	val name: String,
	val origin: Origin,
	val species: String,
	val status: CharacterStatus,
	val type: String
) {

	data class Location(val name: String, val url: String)

	data class Origin(val name: String, val url: String)

	override fun toString(): String {
		return "Character(id=$id, name='$name', type='$type', gender='$gender', origin=$origin, image='$imageUrl')"
	}
}